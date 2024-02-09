package model;

/**
 * An interface for the different types of markings that can be placed on a board.
 * Implementation of the Strategy pattern.
 */
public interface Marking {
    /**
     * Returns a string representation of the marking.
     * @return a string representation of the marking
     */
    String toString();
}
