import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Settings {
    JFrame frame = new JFrame("Settings"); // new window
    public static int speed; // speed nations make a turn at
    public static boolean doWait = false; // should the player have to wait
    public Settings() {

        frame.setSize(400, 300);  // Set the frame's size

        speed = 0; // set the wait time to 0


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Dont end the whole game when closed




        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing


        JButton button1 = new JButton("Change Nation Auto Speed"); // Create button


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("this is just a place holder");



            }
        });


        JButton button2 = new JButton("Slow"); // Create the second button


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = 5;
                doWait = true;
            }
        });




        JButton button3 = new JButton("Medium");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = 3;
                doWait = true;
            }
        });

        JButton button4 = new JButton("Fast");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = 1;
                doWait = true;
            }
        });

        JButton button5 = new JButton("Instant");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = 0;
doWait = false;
            }
        });

        JButton button6 = new JButton("BACK");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
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

        gbc.gridx = 0;
        gbc.gridy = 3;

        frame.add(button4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;

        frame.add(button5, gbc);



        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }


    public int getSpeed() { // return the speed that nations move at
        return speed;
    }
}
