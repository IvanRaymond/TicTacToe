package view;

import model.Board;
import model.Game;
import model.Observer;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class GameViewTextual implements GameView, Observer {
    private final Game game;

    /**
     * Constructor for the GameView.
     * @param game The model.
     */
    public GameViewTextual(Game game) {
        this.game = game;
        game.registerObserver(this);
        showBoard();
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
    private void showBoard() {
        // get board from model
        Board board = this.game.getBoard();

        // clear screen
        clearScreen();

        // print board
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                String marking = board.getMarking(i, j);
                System.out.print(Objects.requireNonNullElse(marking, " "));
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

    private static void clearScreen() {
        // Print 50 empty lines to "clear" the screen
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Show a message.
     * @param message the message to show
     */
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Get the move from the user.
     * @return the move
     */
    @Override
    public int[] getMove() {
        int row = getValidInput("Enter the row: ", game.getBoard().getRows()) - 1;
        int col = getValidInput("Enter the column: ", game.getBoard().getCols()) - 1;
        return new int[]{row, col};
    }

    private int getValidInput(String message, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println(message);
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); // clear the buffer
                input = -1;
            }
        } while (input < 1 || input > max);
        return input;
    }
}
