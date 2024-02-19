package view;

/**
 * GameView interface for the View in the MVC pattern.
 */
public interface GameView {
    /**
     * Show a message.
     * @param message the message to show
     */
    void showMessage(String message);

    /**
     * Get the move from the user.
     * @return the move
     */
    int[] getMove();
}
