package model;

/**
 * Player class
 * @param name name of the player
 * @param mark board marking of the player
 */
public record Player(String name, Marking mark) {
    public String name() {
        return name;
    }

    public Marking mark() {
        return mark;
    }
}
