package controller;

import model.*;
import view.ErrorPopup;

import java.awt.*;

public class GameController {
    private Player WINNER;
    private Player currentPlayer;
    private final Game game;

    public GameController(Game game) {
        this.game = game;
        this.currentPlayer = game.getPlayers().get(0);
        this.WINNER = null;
    }

    private void play(int row, int col) {
        try {
            game.setMarking(row, col, currentPlayer.mark());
            if (game.isWinner(currentPlayer.mark())) {
                setWinner(currentPlayer);
                game.setGameOver(true);
            } else if (game.getBoard().isFull()) {
                game.setGameOver(true);
                game.setDraw(true);
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

    public boolean isDraw() {
        return game.isDraw();
    }

    public void reset() {
        WINNER = null;
        currentPlayer = game.getPlayers().get(0);
        game.setGameOver(false);
        game.setDraw(false);
        game.reset();
    }

    public void gameLoop() {
        InputController inputController = new InputController();

        while (!game.isGameOver()) {
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
