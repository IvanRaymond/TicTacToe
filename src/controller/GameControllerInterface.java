package controller;

import model.Player;

public interface GameControllerInterface {
    Player getWinner();
    void reset();
}
