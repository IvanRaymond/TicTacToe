package model;

public class IllegalMoveException extends Exception {

    /**
     * Constructor for IllegalMoveException
     * @param message the message to display
     */
    public IllegalMoveException(String message) {
        super(message);
    }
}
