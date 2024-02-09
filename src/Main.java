import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", new Circle()));
        players.add(new Player("Player 2", new Cross()));
        // Game Loop
        Game game = new TicTacToe(players);
        Scanner myObj = new Scanner(System.in);

        while (!game.isGameOver()) {
            // Get input
            int x; // get x from input
            int y; // get y from input
            // Get input from terminal
            System.out.println(game.getCurrentPlayer().name() + "'s turn");
            System.out.println("Enter x:");
            x = myObj.nextInt();
            System.out.println("Enter y:");
            y = myObj.nextInt();

            // Play
            game.play(x, y);
        }
        System.out.println("Game Over" + (game.isGameOver() ? " - Winner is " + game.getWinner() : ""));
    }
}






//    enum Marking {
//        CROSS, CIRCLE
//    }
//
//    static class Player {
//        private final Marking marking;
//
//        public Player(Marking marking) {
//            this.marking = marking;
//        }
//
//        public Marking getMarking() {
//            return marking;
//        }
//    }
//
//    static class Board implements model.Subject {
//        private final Player[][] board;
//        private ArrayList<model.Observer> observers;
//
//        public Board() {
//            board = new Player[3][3];
//            observers = new ArrayList<>();
//        }
//
//        public void setMarking(int x, int y, Player player) {
//            board[x][y] = player;
//        }
//
//        public Player getMarking(int x, int y) {
//            return board[x][y];
//        }
//
//        public boolean isFull() {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (board[i][j] == null) {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        public boolean isWinner(Player player) {
//            // Check rows
//            for (int i = 0; i < 3; i++) {
//                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
//                    return true;
//                }
//            }
//            // Check columns
//            for (int i = 0; i < 3; i++) {
//                if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
//                    return true;
//                }
//            }
//            // Check diagonals
//            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
//                return true;
//            }
//            return board[0][2] == player && board[1][1] == player && board[2][0] == player;
//        }
//
//        @Override
//        public void registerObserver(model.Observer observer) {
//            this.observers.add(observer);
//        }
//
//        @Override
//        public void removeObserver(model.Observer observer) {
//            this.observers.remove(observer);
//        }
//
//        @Override
//        public void notifyObservers() {
//            for (model.Observer observer : observers) {
//                observer.update();
//            }
//        }
//    }
//
//    static class Game implements model.Observer, model.Subject {
//        private final Board board;
//        private final ArrayList<Player> players;
//        private Player WINNER;
//        private Player currentPlayer;
//        private ArrayList<model.Observer> observers;
//        private boolean isGameOver;
//
//        public Game(Board board, ArrayList<Player> players) {
//            this.board = board;
//            this.players = players;
//            this.currentPlayer = players.get(0);
//            this.observers = new ArrayList<>();
//            this.WINNER = null;
//        }
//
//        public void play(int x, int y) {
//            board.setMarking(x, y, currentPlayer);
//            checkGameOver();
//            switchPlayer();
//        }
//
//
//
//        public Player getWinner() {
//            return WINNER;
//        }
//
//        private void switchPlayer() {
//            // get the index of the next player
//            int index = players.indexOf(currentPlayer) + 1;
//            if (index == players.size()) {
//                index = 0;
//            }
//            currentPlayer = players.get(index);
//        }
//        public boolean isGameOver() {
//            return isGameOver;
//        }
//
//        @Override
//        public void update() {
//
//        }
//
//        @Override
//        public void registerObserver(model.Observer observer) {
//            this.observers.add(observer);
//        }
//
//        @Override
//        public void removeObserver(model.Observer observer) {
//            this.observers.remove(observer);
//        }
//
//        @Override
//        public void notifyObservers() {
//            for (model.Observer observer : observers) {
//                observer.update();
//            }
//        }
//    }
//
//    interface model.Observer {
//        void update();
//    }
//
//    interface model.Subject {
//        void registerObserver(model.Observer observer);
//        void removeObserver(model.Observer observer);
//        void notifyObservers();
//    }
