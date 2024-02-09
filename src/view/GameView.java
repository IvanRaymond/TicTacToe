package view;

import controller.GameController;
import model.Board;
import model.Game;
import model.Marking;
import model.Observer;

public class GameView implements GameViewInterface, Observer {
    private final Game model;

    /**
     * Constructor for the GameView.
     * @param model The model.
     */
    public GameView(Game model) {
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
        Board board = (Board) this.model.getBoard();

        System.out.flush();

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


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
