package model;

/**
 * Implementation of the Board interface.
 */
public class Board implements BoardInterface {
    private final int x;
    private final int y;
    private Marking[][] board;

    /**
     * Constructor for the Board.
     * @param size the size of the board
     */
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        board = new Marking[x][y];
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
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the x size of the board.
     * @return the x
     */
    @Override
    public int getSizeX() {
        return this.x;
    }
    
    /**
     * Get the y size of the board.
     * @return the y 
     */
    @Override
    public int getSizeY() {
        return this.y;
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
        board = new Marking[x][y];
    }
}
