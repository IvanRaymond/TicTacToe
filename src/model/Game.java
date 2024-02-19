package model;

import java.util.ArrayList;

/**
 * An abstract class for a game.
 */
public abstract class Game implements GameInterface, Subject {
    private Board board;
    private final ArrayList<Player> players;
    private ArrayList<Observer> observers;

    /**
     * Constructor for the Game.
     * @param board the board
     * @param players the players
     */
    public Game(Board board, ArrayList<Player> players) {
        this.board = board;
        this.players = players;
        this.observers = new ArrayList<>();
    }

    /**
     * Set the marking on the board.
     * @param row the row
     * @param col the column
     * @param player the player
     * @throws IllegalMoveException if the move is illegal
     */
    public abstract void setMarking(int row, int col, Player player) throws IllegalMoveException;

    /**
     * Reset the game.
     */
    @Override
    public void reset() {
        board.clear();
        notifyObservers();
    }

    /**
     * Get the board.
     * @return the board
     */
    @Override
    public Board getBoard() {
        return board;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Check if the given marking is a winner.
     * @param player the player to verify
     * @return true if the marking is a winner
     */
    public abstract boolean isWinner(Player player);

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
