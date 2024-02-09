package controller;

import model.*;
import view.ErrorPopup;

import java.awt.*;

public class GameController {
    private Player WINNER;
    private Player currentPlayer;
    private final Game game;
    private boolean isGameOver;

    public GameController(Game game) {
        this.game = game;
        this.currentPlayer = game.getPlayers().get(0);
        this.isGameOver = false;
        this.WINNER = null;
    }

    private void play(int row, int col) {
        try {
            game.setMarking(row, col, currentPlayer.mark());
            if (game.isWinner(currentPlayer.mark())) {
                setWinner(currentPlayer);
                isGameOver = true;
            } else if (game.getBoard().isFull()) {
                isGameOver = true;
            } else {
                switchPlayer();
            }
        } catch (IllegalMoveException e) {
            ErrorPopup.show("Cell already marked");
        }
    }

    private void setWinner(Player player) {
        WINNER = player;
    }

    public Player getWinner() {
        return WINNER;
    }

    public void reset() {
        WINNER = null;
        currentPlayer = game.getPlayers().get(0);
        isGameOver = false;
        game.reset();
    }

    private boolean isGameOver() {
        return isGameOver;
    }

    public void gameLoop() {
        InputController inputController = new InputController();

        while (!this.isGameOver) {
            Point point = null;
            while (point == null) {
                point = inputController.getInput(currentPlayer.name() + "'s turn");
                if (point.x < 0 || point.x >= game.getBoard().getSize() || point.y < 0 || point.y >= game.getBoard().getSize()) {
                    point = null;
                    ErrorPopup.show("Invalid input");
                }
            }
            play(point.x, point.y);
        }
    }

    /**
     * Switch the current player.
     */
    private void switchPlayer() {
        int index = game.getPlayers().indexOf(currentPlayer) + 1;
        if (index == game.getPlayers().size()) {
            index = 0;
        }
        currentPlayer = game.getPlayers().get(index);
    }
}
