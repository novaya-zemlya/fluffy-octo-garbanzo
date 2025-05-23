import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class WaitGUI {
    JFrame frame = new JFrame("While Other Nations Think");  // name of the window
    public WaitGUI() {

        frame.setSize(400, 300);  // Set the frame's size




        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Dont end the whole game when closed




        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing

        JLabel label = new JLabel("Nation " + Globe.moving + " is making turn");





        GridBagConstraints gbc = new GridBagConstraints(); // Set up GridBagConstraints to control the placement and resizing of buttons


        gbc.fill = GridBagConstraints.BOTH;  // Resizes both horizontally and vertically
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add buttons to the frame using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);



        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }






}
