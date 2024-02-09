package model;

public interface BoardInterface {
    void setMarking(int row, int col, Marking marking);
    boolean isFull();
    int getSize();
    Marking getMarking(int row, int col);
    void clear();
}
