package view;

import controller.GameLoop;

public interface GameViewInterface {

    void update();

    void showCurrentPlayer();

    void showBoard();

    void setMarking();

    void showErrorPlacement();

    void showEndGame();

    void setController(GameLoop controller);

    void showDraw();

    void showWinner();

}
