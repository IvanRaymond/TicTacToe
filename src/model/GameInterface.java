package model;

public interface GameInterface {
    void play(int row, int col);
    void reset();
    BoardInterface getBoard();
    boolean isGameOver();
    Player getWinner();
    void switchPlayer();
    Player getCurrentPlayer();
    boolean isWinner(Marking marking);

}
