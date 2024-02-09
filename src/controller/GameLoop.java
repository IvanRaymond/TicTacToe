package controller;

import model.*;

import java.awt.*;
import java.util.ArrayList;

public class GameLoop {
    public void startGame() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", new Circle()));
        players.add(new Player("Player 2", new Cross()));
        // Game Loop
        Game game = new TicTacToe(players);
        InputController inputController = new InputController();

        while (!game.isGameOver()) {
            try {
                Point point = inputController.getInput();
                game.play(point.x, point.y);
            } catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
