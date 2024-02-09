package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a game of Tic Tac Toe.
 */
public class TicTacToe extends Game {

    public TicTacToe(ArrayList<Player> players) {
        super(new Board(3), players);
    }

    /**
     * Set the marking on the board.
     * @param row the row
     * @param col the column
     * @param marking the marking to set
     * @throws IllegalMoveException
     */
    @Override
    public void setMarking(int row, int col, Marking marking) throws IllegalMoveException {
        if (getBoard().getMarking(row, col) != null) {
            throw new IllegalMoveException("The cell is already occupied");
        }
        getBoard().setMarking(row, col, marking);
        notifyObservers();
    }

    /**
     * Check if the given marking is a winner.
     * @param marking the marking to check
     * @return true if the marking is a winner
     */
    @Override
    public boolean isWinner(Marking marking) {
        for (int i = 0; i < getBoard().getSize(); i++) {
            if (getBoard().getMarking(i, 0) == marking && getBoard().getMarking(i, 1) == marking && getBoard().getMarking(i, 2) == marking) {
                return true;
            }
            if (getBoard().getMarking(0, i) == marking && getBoard().getMarking(1, i) == marking && getBoard().getMarking(2, i) == marking) {
                return true;
            }
        }
        if (getBoard().getMarking(0, 0) == marking && getBoard().getMarking(1, 1) == marking && getBoard().getMarking(2, 2) == marking) {
            return true;
        }
        return getBoard().getMarking(0, 2) == marking && getBoard().getMarking(1, 1) == marking && getBoard().getMarking(2, 0) == marking;
    }
}
