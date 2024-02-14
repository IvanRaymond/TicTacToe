package controller;

import model.*;
import view.GameViewGUI;

import javax.swing.*;

public class GameController {
    private final GameState gameState;
    private final Game game;
    private final GameViewGUI view;

    public GameController(Game game, GameState gameState, GameViewGUI view) {
        this.game = game;
        this.gameState = gameState;
        this.view = view;

        // Add action listeners to view's buttons
        for (int i = 0; i < game.getBoard().getRows(); i++) {
            for (int j = 0; j < game.getBoard().getCols(); j++) {
                final int row = i;
                final int col = j;
                view.addButtonListener(i, j, e -> handleButtonClick(row, col));
            }
        }
    }

    private void play(int row, int col) {
        try {
            game.setMarking(row, col, gameState.getCurrentPlayer().mark());
            if (game.isWinner(gameState.getCurrentPlayer().mark())) {
                setWinner(gameState.getCurrentPlayer());
                gameState.setGameOver(true);
                view.showMessage(gameState.getWinner().name() + " wins!");
            } else if (game.getBoard().isFull()) {
                gameState.setGameOver(true);
                gameState.setDraw(true);
                view.showMessage("It's a draw!");
            } else {
                switchCurrentPlayer();
            }
        } catch (IllegalMoveException e) {
            JOptionPane.showMessageDialog(null, "Cell already marked");
        }
    }

    private void setWinner(Player player) {
        gameState.setWinner(player);
    }

    /**
     * Switch the current player.
     */
    private void switchCurrentPlayer() {
        int index = game.getPlayers().indexOf(gameState.getCurrentPlayer()) + 1;
        if (index == game.getPlayers().size()) {
            index = 0;
        }
        gameState.setCurrentPlayer(game.getPlayers().get(index));
    }

    private void handleButtonClick(int row, int col) {
        if (gameState.isGameOver()) {
            return;
        }
        view.updateButton(row, col, gameState.getCurrentPlayer().mark().toString());
        play(row, col);
    }
}
