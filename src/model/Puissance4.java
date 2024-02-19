package model;

import java.util.ArrayList;

public class Puissance4 extends Game{

	public Puissance4(ArrayList<Player> players) {
		super(new Board(6,7), players);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMarking(int row, int col, Marking marking) throws IllegalMoveException {
		 if (getBoard().getMarking(row, col) != null) {
	            throw new IllegalMoveException("The cell is already occupied");
	        }
	        getBoard().setMarking(row, col, marking);
	        notifyObservers();
	}

	@Override
	public boolean isWinner(Marking marking) {
		// TODO Auto-generated method stub
		//Vérication en ligne
		for(int row = 0; row < getBoard().getSizeX(); row++){
			for (int col = 0;col < getBoard().getSizeY() - 3;col++){
				if (getBoard().getMarking(row, col) == marking && 
					getBoard().getMarking(row, col + 1) == marking &&
					getBoard().getMarking(row, col + 2) == marking &&
					getBoard().getMarking(row, col + 3) == marking){
					return true;
				}
			}			
		}
		
		//Vérication en colonne
		for(int row = 0; row < getBoard().getSizeX() - 3; row++){
			for (int col = 0;col < getBoard().getSizeY();col++){
				if (getBoard().getMarking(row, col) == marking && 
					getBoard().getMarking(row + 1, col) == marking &&
					getBoard().getMarking(row + 2, col) == marking &&
					getBoard().getMarking(row + 3, col) == marking){
					return true;
				}
			}			
		}
		
		//Vérication en diagonale montante
		for(int row = 3; row < getBoard().getSizeX(); row++){
			for (int col = 0;col < getBoard().getSizeY() - 3;col++){
				if (getBoard().getMarking(row, col) == marking && 
					getBoard().getMarking(row - 1, col + 1) == marking &&
					getBoard().getMarking(row - 2, col + 2) == marking &&
					getBoard().getMarking(row - 3, col + 3) == marking){
					return true;
				}
			}			
		}
		
		
		//Vérication en diagonale descendante
		for(int row = 0; row < getBoard().getSizeX() - 3; row++){
			for (int col = 0;col < getBoard().getSizeY() - 3;col++){
				if (getBoard().getMarking(row, col) == marking && 
					getBoard().getMarking(row + 1, col + 1) == marking &&
					getBoard().getMarking(row + 2, col + 2) == marking &&
					getBoard().getMarking(row + 3, col + 3) == marking){
					return true;
				}
			}			
		}
		
		return false;
		
	}

}
