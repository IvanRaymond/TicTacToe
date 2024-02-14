package model;

/**
 * Implementation of the Board interface.
 */
public class Board implements BoardInterface {
    private final int rows;
    private final int cols;
    private Marking[][] board;

    /**
     * Constructor for the Board.
     * @param rows the number of rows
     * @param cols the number of columns
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Marking[rows][cols];
    }

    /**
     * Set the marking on the board.
     * @param row row
     * @param col column
     * @param marking the marking
     */
    @Override
    public void setMarking(int row, int col, Marking marking) {
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
     * Get the size of the board.
     * @return the size
     */
    @Override
    public int getRows() {
        return rows;
    }

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
    public Marking getMarking(int row, int col) {
        return board[row][col];
    }

    /**
     * Clear the board.
     */
    @Override
    public void clear() {
        board = new Marking[rows][cols];
    }
}
