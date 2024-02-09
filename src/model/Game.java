package model;

import java.util.ArrayList;

public abstract class Game implements GameInterface, Subject {
    private BoardInterface board;
    private Player currentPlayer;
    private final ArrayList<Player> players;
    private Player WINNER;
    private boolean isGameOver;
    private ArrayList<Observer> observers;

    public Game(BoardInterface board, ArrayList<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayer = players.get(0);
        this.observers = new ArrayList<>();
        this.WINNER = null;
    }

    @Override
    public void play(int row, int col) {
        board.setMarking(row, col, currentPlayer.mark());
        checkGameOver();
        switchPlayer();
        notifyObservers();
    }

    private void checkGameOver() {
        if (isWinner(currentPlayer.mark()) || board.isFull()) {
            isGameOver = true;
        }
        if (isWinner(currentPlayer.mark())) {
            WINNER = currentPlayer;
        }
    }

    @Override
    public void reset() {
        board.clear();
        isGameOver = false;
        WINNER = null;
        currentPlayer = players.get(0);
        notifyObservers();
    }

    @Override
    public BoardInterface getBoard() {
        return board;
    }

    @Override
    public boolean isGameOver() {
        return isGameOver;
    }

    @Override
    public Player getWinner() {
        return WINNER;
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void switchPlayer() {
        int index = players.indexOf(currentPlayer) + 1;
        if (index == players.size()) {
            index = 0;
        }
        currentPlayer = players.get(index);
    }

    public abstract boolean isWinner(Marking marking);

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
