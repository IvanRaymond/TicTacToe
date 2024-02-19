package model;

/**
 * Implementation of the Board interface.
 */
public class Board implements BoardInterface {
    private final int rows;
    private final int cols;
    private String[][] board;

    /**
     * Constructor for the Board.
     * @param rows the number of rows
     * @param cols the number of columns
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new String[rows][cols];
    }

    /**
     * Set the marking on the board.
     * @param row row
     * @param col column
     * @param marking the marking
     */
    @Override
    public void setMarking(int row, int col, String marking) {
        board[row][col] = marking;
    }

    /**
     * Check if the board is full.
     * @return true if the board is full
     */
    @Override
    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the number of rows.
     * @return the number of rows
     */
    @Override
    public int getRows() {
        return rows;
    }

    /**
     * Get the number of columns.
     * @return the number of columns
     */
    @Override
    public int getCols() {
        return cols;
    }

    /**
     * Get the marking at the given row and column.
     * @param row row
     * @param col column
     * @return the marking
     */
    @Override
    public String getMarking(int row, int col) {
        return board[row][col];
    }

    /**
     * Clear the board.
     */
    @Override
    public void clear() {
        board = new String[rows][cols];
    }
}
