package model;

/**
 * Interface for the game
 */
public interface GameInterface {

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
     * Check if a player has won
     * @param player the marking to check
     * @return true if the player has won
     */
    boolean isWinner(Player player);

}
