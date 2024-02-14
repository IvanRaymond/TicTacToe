package model;

public class GameState {
    private Player WINNER;
    private Player currentPlayer;
    private boolean isGameOver;
    private boolean isDraw;

    public GameState(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.WINNER = null;
        this.isGameOver = false;
        this.isDraw = false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void setWinner(Player player) {
        WINNER = player;
    }

    public Player getWinner() {
        return WINNER;
    }

    public boolean isDraw() {
        return this.isDraw;
    }

    public void setDraw(boolean draw) {
        this.isDraw = draw;
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.isGameOver = gameOver;
    }

    public void reset(Player currentPlayer) {
        WINNER = null;
        isGameOver = false;
        isDraw = false;
        this.currentPlayer = currentPlayer;
    }
}
