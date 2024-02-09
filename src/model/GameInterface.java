package model;

/**
 * Interface for the game
 */
public interface GameInterface {
    /**
     * Play a move on the board
     * @param row row
     * @param col column
     */
    void play(int row, int col) throws IllegalMoveException;

    /**
     * Reset the game
     */
    void reset();

    /**
     * Get the board
     * @return the board
     */
    BoardInterface getBoard();

    /**
     * Check if the game is over
     * @return true if the game is over
     */
    boolean isGameOver();

    /**
     * Get the winner of the game
     * @return the winner
     */
    Player getWinner();

    /**
     * Switch the current player
     */
    void switchPlayer();

    /**
     * Get the current player
     * @return the current player
     */
    Player getCurrentPlayer();

    /**
     * Check if a player has won
     * @param marking the marking to check
     * @return true if the player has won
     */
    boolean isWinner(Marking marking);

}
