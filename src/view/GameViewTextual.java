package view;

import model.Board;
import model.Game;
import model.Marking;
import model.Observer;

public class GameViewTextual implements GameViewInterface, Observer {
    private final Game model;

    /**
     * Constructor for the GameView.
     * @param model The model.
     */
    public GameViewTextual(Game model) {
        this.model = model;
    }

    /**
     * Update the view.
     */
    @Override
    public void update() {
        // refresh the view
        showBoard();
    }

    /**
     * Show the board.
     */
    public void showBoard() {
        // get board from model
        Board board = this.model.getBoard();

        // clear screen
        clearScreen();

        // print board
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Marking marking = board.getMarking(i, j);
                if (marking == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(marking);
                }
                if (j < board.getCols() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.getRows() - 1) {
                for (int j = 0; j < board.getCols(); j++) {
                    System.out.print("-");
                    if (j < board.getCols() - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void clearScreen() {
        // Print 50 empty lines to "clear" the screen
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
