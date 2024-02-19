package model;

import java.util.ArrayList;

public class Connect4 extends Game {
    /**
     * Constructor for the Game.
     *
     * @param board   the board
     * @param players the players
     */
    public Connect4(Board board, ArrayList<Player> players) {
        super(board, players);
    }

    /**
     * Set the marking on the board.
     *
     * @param row    the row
     * @param col    the column
     * @param player the player
     * @throws IllegalMoveException if the move is illegal
     */
    @Override
    public void setMarking(int row, int col, Player player) throws IllegalMoveException {
        if (getBoard().getMarking(getBoard().getRows(), col) != null) {
            throw new IllegalMoveException("The column is already occupied");
        }
        // place the marking in the lowest available row
        for (int i = getBoard().getRows() - 1; i >= 0; i--) {
            if (getBoard().getMarking(i, col) == null) {
                getBoard().setMarking(i, col, player.mark());
                notifyObservers();
            }
        }
    }

    /**
     * Check if the given marking is a winner.
     *
     * @param player the player to verify
     * @return true if the marking is a winner
     */
    @Override
    public boolean isWinner(Player player) {
        return checkRows(player.mark()) || checkCols(player.mark()) || checkDiagonals(player.mark());
    }

    private boolean checkRows(String marking) {
        for (int i = 0; i < getBoard().getRows(); i++) {
            for (int j = 0; j < getBoard().getCols() - 3; j++) {
                if (checkRow(i, j, marking)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRow(int row, int col, String marking) {
        for (int i = 0; i < 4; i++) {
            if (!getBoard().getMarking(row, col + i).equals(marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCols(String marking) {
        for (int i = 0; i < getBoard().getCols(); i++) {
            for (int j = 0; j < getBoard().getRows() - 3; j++) {
                if (checkCol(j, i, marking)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCol(int row, int col, String marking) {
        for (int i = 0; i < 4; i++) {
            if (!getBoard().getMarking(row + i, col).equals(marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(String marking) {
        for (int i = 0; i < getBoard().getRows() - 3; i++) {
            for (int j = 0; j < getBoard().getCols() - 3; j++) {
                if (checkDiagonal(i, j, marking) || checkAntiDiagonal(i, j, marking)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(int row, int col, String marking) {
        for (int i = 0; i < 4; i++) {
            if (!getBoard().getMarking(row + i, col + i).equals(marking)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonals(String marking) {
        for (int i = 0; i < getBoard().getRows() - 3; i++) {
            for (int j = 3; j < getBoard().getCols(); j++) {
                if (checkAntiDiagonal(i, j, marking)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkAntiDiagonal(int row, int col, String marking) {
        for (int i = 0; i < 4; i++) {
            if (!getBoard().getMarking(row + i, col - i).equals(marking)) {
                return false;
            }
        }
        return true;
    }
}
