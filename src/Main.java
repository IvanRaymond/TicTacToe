import controller.GameController;
import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", new Circle()));
        players.add(new Player("Player 2", new Cross()));
        Game game = new TicTacToe(players);
        GameController controller = new GameController(game);
        controller.gameLoop();
    }
}