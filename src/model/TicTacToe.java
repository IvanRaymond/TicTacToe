package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a game of Tic Tac Toe.
 */
public class TicTacToe extends Game {

    public TicTacToe(ArrayList<Player> players) {
        super(new Board(3, 3), players);
    }

    /**
     * Set the marking on the board.
     * @param row the row
     * @param col the column
     * @param marking the marking to set
     * @throws IllegalMoveException bad move exception
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
        return checkRows(marking) || checkCols(marking) || checkDiagonals(marking);
    }

    private boolean checkRows(Marking marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (checkRow(i, marking)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row, Marking marking) {
        for (int i = 0; i < getBoard().getCols(); i++) {
            if (!Objects.equals(getBoard().getMarking(row, i), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(Marking marking) {
        for (int i = 0; i < getBoard().getCols(); i++) {
            if (checkCol(i, marking)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int col, Marking marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, col), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(Marking marking) {
        return checkDiagonal1(marking) || checkDiagonal2(marking);
    }

    private boolean checkDiagonal1(Marking marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, i), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal2(Marking marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, getBoard().getCols() - i - 1), marking)) {
                return false;
            }
        }
        return true;
    }
}
