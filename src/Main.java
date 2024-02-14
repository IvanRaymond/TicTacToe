import controller.GameController;
import model.*;
import view.GameViewGUI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", new Circle()));
        players.add(new Player("Player 2", new Cross()));
        Game game = new TicTacToe(players);
        GameState gameState = new GameState(players.get(0));
        GameViewGUI view = new GameViewGUI(game.getBoard().getRows(), game.getBoard().getCols());
        new GameController(game, gameState, view);
    }
}