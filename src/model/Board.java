package model;

public class Board implements BoardInterface {
    private final int size;
    private Marking[][] board;

    public Board(int size) {
        this.size = size;
        board = new Marking[size][size];
    }

    @Override
    public void setMarking(int row, int col, Marking marking) {
        board[row][col] = marking;
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Marking getMarking(int row, int col) {
        return board[row][col];
    }

    @Override
    public void clear() {
        board = new Marking[size][size];
    }
}
