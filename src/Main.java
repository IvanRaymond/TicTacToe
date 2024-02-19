import controller.GameController;
import model.*;
import view.GameViewTextual;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", "O"));
        players.add(new Player("Player 2", "X"));
        Game game = new TicTacToe(players);
        GameState gameState = new GameState(players.get(0));
        GameViewTextual view = new GameViewTextual(game);
        new GameController(game, gameState, view);
    }
}