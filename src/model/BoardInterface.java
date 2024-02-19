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
    void setMarking(int row, int col, Marking marking);

    /**
     * Check if the board is full.
     * @return true if the board is full
     */
    boolean isFull();

    /**
     * Get the marking at the given row and column.
     * @param row row
     * @param col column
     * @return the marking
     */
    Marking getMarking(int row, int col);

    /**
     * Clear the board.
     */
    void clear();

	/**
	 * Get the size of the board.
	 * @return the size
	 */
	int getSizeX();

	/**
	 * Get the y size of the board.
	 * @return the y 
	 */
	int getSizeY();
}
