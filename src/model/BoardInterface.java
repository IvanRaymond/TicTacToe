package model;

/**
 * An interface for a board.
 */
public interface BoardInterface {
    /**
     * Set the marking at the given row and column.
     * @param row row
     * @param col column
     * @param marking the marking
     */
    void setMarking(int row, int col, String marking);

    /**
     * Check if the board is full.
     * @return true if the board is full
     */
    boolean isFull();

    /**
     * Get the rows of the board.
     * @return the number of rows
     */
    int getRows();

    /**
     * Get the number of columns of the board.
     * @return the number of columns
     */
    int getCols();

    /**
     * Get the marking at the given row and column.
     * @param row row
     * @param col column
     * @return the marking
     */
    String getMarking(int row, int col);

    /**
     * Clear the board.
     */
    void clear();
}
