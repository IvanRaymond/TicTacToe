package view;

import controller.GameLoop;
import model.Board;
import model.Game;
import model.IllegalMoveException;
import model.Marking;
import model.Observer;

public class GameView implements GameViewInterface, Observer {

    private GameLoop controller;
    private Game model;

    /**
     * Constructor for the GameView.
     * @param controller
     * @param model
     */
    public GameView(GameLoop controller, Game model) {
        this.controller = controller;
        this.model = model;
    }

    /**
     * Update the view.
     */
    @Override
    public void update() {
        this.showCurrentPlayer();
        this.showBoard();
        if (this.model.isGameOver()) {
            this.showEndGame();
            if (this.model.getWinner() == null) {
                this.showDraw();
            } else {
                this.showWinner();
            }
        }
    }

    /**
     * Show the current player.
     */
    public void showCurrentPlayer() {
        System.out.println("Current player: " + this.model.getCurrentPlayer().name());   
    }

    /**
     * Show the board.
     */
    public void showBoard() {
        // get board from model
        Board board = (Board) this.model.getBoard();

        // print board
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Marking marking = board.getMarking(i, j);
                if (marking == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(marking);
                }
                if (j < board.getSize() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.getSize() - 1) {
                for (int j = 0; j < board.getSize(); j++) {
                    System.out.print("-");
                    if (j < board.getSize() - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Set the marking on the board.
     */
    public void setMarking() {
        try {
            this.controller.handleMarking();
        } catch (IllegalMoveException e) {
            this.showErrorPlacement();
        }
    }

    /**
     * Show an error message for invalid placement.
     */
    public void showErrorPlacement() {
        System.out.println("Invalid placement");
    }

    /**
     * Show the end game message.
     */
    public void showEndGame() {
        System.out.println("Game over!");
    }

    /**
     * Set the controller.
     * @param controller
     */
    public void setController(GameLoop controller) {
        this.controller = controller;
    }

    /**
     * Show draw message.
     */
    public void showDraw() {
        System.out.println("No winner!");
    }

    /**
     * Show the winner.
     */
    public void showWinner() {
        System.out.println("The winner is: " + this.model.getWinner().name());
    }
}
