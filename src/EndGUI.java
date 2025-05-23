import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EndGUI {
    JFrame frame = new JFrame("Game Over"); // the name of the window
    String text; // the text that will be displaed
    public EndGUI() throws InterruptedException{

        frame.setSize(400, 300);  // Set the frame's size




        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Dont end the whole game when closed




        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing

        if (Globe.nationList.getFirst().isDone()){
            text = "You Lost";

        }
        else{
            text = "congrats";
        }

        JLabel label = new JLabel(text); // what will be displayed





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
        Thread.sleep(20000);
        System.exit(0);

    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }

}
