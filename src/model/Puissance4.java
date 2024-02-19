package model;

import java.util.ArrayList;

public class Puissance4 extends Game{

	public Puissance4(ArrayList<Player> players) {
		super(new Board(6,7), players);
	}

	@Override
	public void setMarking(int row, int col, Player player) throws IllegalMoveException {
		 if (getBoard().getMarking(row, col) != null) {
	            throw new IllegalMoveException("The cell is already occupied");
	        }
	        getBoard().setMarking(row, col, player.mark());
	        notifyObservers();
	}

	@Override
	public boolean isWinner(Player player) {
		//V�rication en ligne
		for(int row = 0; row < getBoard().getCols(); row++){
			for (int col = 0;col < getBoard().getRows() - 3;col++){
				if (getBoard().getMarking(row, col).equals(player.mark()) &&
					getBoard().getMarking(row, col + 1).equals(player.mark()) &&
					getBoard().getMarking(row, col + 2).equals(player.mark()) &&
					getBoard().getMarking(row, col + 3).equals(player.mark())){
					return true;
				}
			}
		}

		//V�rication en colonne
		for(int row = 0; row < getBoard().getCols() - 3; row++){
			for (int col = 0; col < getBoard().getRows(); col++){
				if (getBoard().getMarking(row, col).equals(player.mark()) &&
						getBoard().getMarking(row + 1, col).equals(player.mark()) &&
						getBoard().getMarking(row + 2, col).equals(player.mark()) &&
						getBoard().getMarking(row + 3, col).equals(player.mark())){
					return true;
				}
			}
		}

		//V�rication en diagonale montante
		for(int row = 3; row < getBoard().getCols(); row++){
			for (int col = 0;col < getBoard().getRows() - 3;col++){
				if (getBoard().getMarking(row, col).equals(player.mark()) &&
					getBoard().getMarking(row - 1, col + 1).equals(player.mark()) &&
					getBoard().getMarking(row - 2, col + 2).equals(player.mark()) &&
					getBoard().getMarking(row - 3, col + 3).equals(player.mark())){
					return true;
				}
			}
		}


		//V�rication en diagonale descendante
		for(int row = 0; row < getBoard().getCols() - 3; row++){
			for (int col = 0;col < getBoard().getRows() - 3;col++){
				if (getBoard().getMarking(row, col).equals(player.mark()) &&
					getBoard().getMarking(row + 1, col + 1).equals(player.mark()) &&
					getBoard().getMarking(row + 2, col + 2).equals(player.mark()) &&
					getBoard().getMarking(row + 3, col + 3).equals(player.mark())){
					return true;
				}
			}			
		}
		
		return false;
		
	}

}
