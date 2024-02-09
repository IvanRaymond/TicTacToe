package model;

import java.util.ArrayList;

public class TicTacToe extends Game {

    public TicTacToe(ArrayList<Player> players) {
        super(new Board(3), players);
    }

    @Override
    public boolean isWinner(Marking marking) {
        for (int i = 0; i < getBoard().getSize(); i++) {
            if (getBoard().getMarking(i, 0) == marking && getBoard().getMarking(i, 1) == marking && getBoard().getMarking(i, 2) == marking) {
                return true;
            }
            if (getBoard().getMarking(0, i) == marking && getBoard().getMarking(1, i) == marking && getBoard().getMarking(2, i) == marking) {
                return true;
            }
        }
        if (getBoard().getMarking(0, 0) == marking && getBoard().getMarking(1, 1) == marking && getBoard().getMarking(2, 2) == marking) {
            return true;
        }
        return getBoard().getMarking(0, 2) == marking && getBoard().getMarking(1, 1) == marking && getBoard().getMarking(2, 0) == marking;
    }
}
