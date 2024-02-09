package model;

public record Player(String name, Marking mark) {
    public String name() {
        return name;
    }

    public Marking mark() {
        return mark;
    }
}
