package view;

import javax.swing.*;
import java.awt.*;

public class NextMovePopup {
    public Point getPoint() {
        // Create JPanel to hold input fields
        JPanel panel = new JPanel();
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);

        // Add input fields to the panel
        panel.add(new JLabel("X Coordinate:"));
        panel.add(xField);
        panel.add(Box.createHorizontalStrut(15)); // Add some space between the components
        panel.add(new JLabel("Y Coordinate:"));
        panel.add(yField);

        // Display the panel in a JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel,
                "Enter Coordinates", JOptionPane.OK_CANCEL_OPTION);

        // Check if the user clicked OK
        if (result == JOptionPane.OK_OPTION) {
            // Retrieve and parse the coordinates
            try {
                int xCoordinate = Integer.parseInt(xField.getText());
                int yCoordinate = Integer.parseInt(yField.getText());
                return new Point(xCoordinate, yCoordinate);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers for both coordinates.");
            }
        }
        return null;
    }


}
