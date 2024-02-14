package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameViewGUI extends JFrame {
    private JButton[][] buttons;

    public GameViewGUI(int rows, int cols) {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(rows, cols));
        initializeButtons(rows, cols);
        setVisible(true);
    }

    private void initializeButtons(int rows, int cols) {
        buttons = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    public void addButtonListener(int row, int col, ActionListener listener) {
        buttons[row][col].addActionListener(listener);
    }

    public void updateButton(int row, int col, String mark) {
        buttons[row][col].setText(mark);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
