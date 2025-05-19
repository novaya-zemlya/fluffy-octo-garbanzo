import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MenuMk2 {
    JFrame frame = new JFrame("Start"); // new window
    private boolean start = false;
    public MenuMk2() {

        frame.setSize(400, 300);  // Set the frame's size


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Ensure the program exits when the window is closed


        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing


        JButton button1 = new JButton("START"); // Create button


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start){
                    if (Globe.nationList.getFirst().isDone()){
                        System.out.println("restart program to run new game");
                    }
                    else {
                        System.out.println("Already started");
                    }
                }
                else {
                    System.out.println("Start");
                    start = true;
                    frame.setVisible(false);
                }




            }
        });


        JButton button2 = new JButton("Help"); // Create the second button


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About ab = new About();



            }
        });




        JButton button3 = new JButton("Settings");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings op = new Settings();
            }
        });



        GridBagConstraints gbc = new GridBagConstraints(); // Set up GridBagConstraints to control the placement and resizing of buttons


        gbc.fill = GridBagConstraints.BOTH;  // Resizes both horizontally and vertically
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing around buttons

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

        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }

    public boolean isStart() { // get the is start variable
        return start;
    }
}
