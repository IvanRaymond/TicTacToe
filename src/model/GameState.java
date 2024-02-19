package model;

public class GameState {
    private Player WINNER;
    private Player currentPlayer;
    private boolean isGameOver;
    private boolean isDraw;

    /**
     * Constructor for GameState
     * @param currentPlayer the current player
     */
    public GameState(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.WINNER = null;
        this.isGameOver = false;
        this.isDraw = false;
    }

    /**
     * Get the current player
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Set the current player
     * @param player the current player
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    /**
     * Set the winner
     * @param player the winner
     */
    public void setWinner(Player player) {
        WINNER = player;
    }

    /**
     * Get the winner
     * @return the winner
     */
    public Player getWinner() {
        return WINNER;
    }

    /**
     * Check if the game is a draw
     * @return true if the game is a draw
     */
    public boolean isDraw() {
        return this.isDraw;
    }

    /**
     * Set if the game is a draw
     * @param draw true if the game is a draw
     */
    public void setDraw(boolean draw) {
        this.isDraw = draw;
    }

    /**
     * Check if the game is over
     * @return true if the game is over
     */
    public boolean isGameOver() {
        return this.isGameOver;
    }

    /**
     * Set if the game is over
     * @param gameOver true if the game is over
     */
    public void setGameOver(boolean gameOver) {
        this.isGameOver = gameOver;
    }

    /**
     * Reset the game
     * @param currentPlayer the current player
     */
    public void reset(Player currentPlayer) {
        WINNER = null;
        isGameOver = false;
        isDraw = false;
        this.currentPlayer = currentPlayer;
    }
}
