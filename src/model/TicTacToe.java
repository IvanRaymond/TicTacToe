package model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A class representing a game of Tic Tac Toe.
 */
public class TicTacToe extends Game {

    /**
     * Constructor for the TicTacToe game.
     * @param players the players
     */
    public TicTacToe(ArrayList<Player> players) {
        super(new Board(3, 3), players);
    }

    /**
     * Set the marking on the board.
     * @param row the row
     * @param col the column
     * @param player the marking to set
     * @throws IllegalMoveException bad move exception
     */
    @Override
    public void setMarking(int row, int col, Player player) throws IllegalMoveException {
        if (getBoard().getMarking(row, col) != null) {
            throw new IllegalMoveException("The cell is already occupied");
        }
        getBoard().setMarking(row, col, player.mark());
        notifyObservers();
    }

    /**
     * Check if the given marking is a winner.
     * @param player the marking to check
     * @return true if the marking is a winner
     */
    @Override
    public boolean isWinner(Player player) {
        return checkRows(player.mark()) || checkCols(player.mark()) || checkDiagonals(player.mark());
    }

    private boolean checkRows(String marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (checkRow(i, marking)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row, String marking) {
        for (int i = 0; i < getBoard().getCols(); i++) {
            if (!Objects.equals(getBoard().getMarking(row, i), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(String marking) {
        for (int i = 0; i < getBoard().getCols(); i++) {
            if (checkCol(i, marking)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int col, String marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, col), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(String marking) {
        return checkDiagonal1(marking) || checkDiagonal2(marking);
    }

    private boolean checkDiagonal1(String marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, i), marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal2(String marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            if (!Objects.equals(getBoard().getMarking(i, getBoard().getCols() - i - 1), marking)) {
                return false;
            }
        }
        return true;
    }
}
