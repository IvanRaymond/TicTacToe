package model;

import java.util.ArrayList;

/**
 * An abstract class for a game.
 */
public abstract class Game implements GameInterface, Subject {
    private BoardInterface board;
    private Player currentPlayer;
    private final ArrayList<Player> players;
    private Player WINNER;
    private boolean isGameOver;
    private ArrayList<Observer> observers;

    /**
     * Constructor for the Game.
     * @param board the board
     * @param players the players
     */
    public Game(BoardInterface board, ArrayList<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayer = players.get(0);
        this.observers = new ArrayList<>();
        this.WINNER = null;
    }

    /**
     * Play a move.
     * @param row row
     * @param col column
     */
    @Override
    public void play(int row, int col) throws IllegalMoveException {
        board.setMarking(row, col, currentPlayer.mark());
        checkGameOver();
        switchPlayer();
        notifyObservers();
    }

    /**
     * Check if the game is over.
     */
    private void checkGameOver() {
        if (isWinner(currentPlayer.mark()) || board.isFull()) {
            isGameOver = true;
        }
        if (isWinner(currentPlayer.mark())) {
            WINNER = currentPlayer;
        }
    }

    /**
     * Reset the game.
     */
    @Override
    public void reset() {
        board.clear();
        isGameOver = false;
        WINNER = null;
        currentPlayer = players.get(0);
        notifyObservers();
    }

    /**
     * Get the board.
     * @return the board
     */
    @Override
    public BoardInterface getBoard() {
        return board;
    }

    /**
     * Check if the game is over.
     * @return true if the game is over
     */
    @Override
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * Get the winner.
     * @return the winner
     */
    @Override
    public Player getWinner() {
        return WINNER;
    }

    /**
     * Get the current player.
     * @return the current player
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Switch the current player.
     */
    @Override
    public void switchPlayer() {
        int index = players.indexOf(currentPlayer) + 1;
        if (index == players.size()) {
            index = 0;
        }
        currentPlayer = players.get(index);
    }

    /**
     * Check if the given marking is a winner.
     * @param marking the marking to check
     * @return true if the marking is a winner
     */
    public abstract boolean isWinner(Marking marking);

    /**
     * Register an observer.
     * @param observer the observer
     */
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Remove an observer.
     * @param observer the observer
     */
    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Notify the observers.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
