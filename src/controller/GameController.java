package controller;

import model.*;
import view.GameView;


/**
 * The controller for the game.
 */
public class GameController {
    private final GameState gameState;
    private final Game game;
    private final GameView view;

    /**
     * Constructor for the GameController.
     * @param game The model.
     * @param gameState The state of the game.
     * @param view The view.
     */
    public GameController(Game game, GameState gameState, GameView view) {
        this.game = game;
        this.gameState = gameState;
        this.view = view;

        // Start the game loop
        gameLoop();
    }

    /**
     * The game loop.
     */
    private void gameLoop() {
        while (!gameState.isGameOver()) {
            view.showMessage(gameState.getCurrentPlayer().name() + "'s turn");
            int[] move = view.getMove();
            play(move[0], move[1]);
        }
    }

    /**
     * Play a move.
     * @param row The row.
     * @param col The column.
     */
    private void play(int row, int col) {
        try {
            game.setMarking(row, col, gameState.getCurrentPlayer());
            if (game.isWinner(gameState.getCurrentPlayer())) {
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
            view.showMessage("Cell already marked");
        }
    }

    /**
     * Set the winner of the game.
     * @param player The winner.
     */
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
}
