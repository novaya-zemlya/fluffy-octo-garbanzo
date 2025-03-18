import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

    public static void main(String[] args) {
        // Create a frame (window)
        JFrame frame = new JFrame("Button Click Example");

        // Set the frame's size
        frame.setSize(400, 300);

        // Ensure the program exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout
        frame.setLayout(new GridBagLayout());

        // Create the first button
        JButton button1 = new JButton("Click Me!");

        // Add an ActionListener to the first button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print a message when the first button is clicked
                System.out.println("Button 1 was clicked!");
            }
        });

        // Create the second button
        JButton button2 = new JButton("Click Me Too!");

        // Add an ActionListener to the second button
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print a different message when the second button is clicked
                System.out.println("Button 2 was clicked!");
            }
        });


        JButton button3 = new JButton("Test");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi");
            }
        });


        // Set up GridBagConstraints to control the placement and resizing of buttons
        GridBagConstraints gbc = new GridBagConstraints();

        // Allow buttons to resize both horizontally and vertically
        gbc.fill = GridBagConstraints.BOTH;  // Resizes both horizontally and vertically
        gbc.weightx = 1.0; // Allow horizontal resizing
        gbc.weighty = 1.0; // Allow vertical resizing
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing around the buttons

        // Add buttons to the frame using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(button1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        frame.add(button2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        frame.add(button3, gbc);

        // Make the frame visible
        frame.setVisible(true);
    }
}
