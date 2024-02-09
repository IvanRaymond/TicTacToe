package model;

/**
 * Implementation of the Board interface.
 */
public class Board implements BoardInterface {
    private final int size;
    private Marking[][] board;

    /**
     * Constructor for the Board.
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        board = new Marking[size][size];
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
    public int getSize() {
        return size;
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
        board = new Marking[size][size];
    }
}
