package model;

/**
 * Player class
 * @param name name of the player
 * @param mark board marking of the player
 */
public record Player(String name, String mark) {
    public String name() {
        return name;
    }

    public String mark() {
        return mark;
    }
}
