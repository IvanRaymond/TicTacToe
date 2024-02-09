package controller;

import view.NextMovePopup;

import java.awt.*;

public class InputController implements InputControllerInterface {
    @Override
    public Point getInput() {
        NextMovePopup nextMovePopup = new NextMovePopup();

        return nextMovePopup.getPoint();
    }
}
