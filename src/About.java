
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class About {
    JFrame frame = new JFrame("Help"); // new window


    public About() {

        frame.setSize(400, 300);  // Set the frame's size



        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // dont end the whole game when closed



        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing



        JButton button1 = new JButton("Goal"); // Create button


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Welcome commander, you are in charge of a nation through perilous times. Your goal is to get all nations to surrender.");
                JOptionPane.showMessageDialog(frame,"A nation will surrender if invaded, or if their population falls below 1000. ");

            }
        });

        JButton button2 = new JButton("Surrender"); // Create button


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "think all hope is lost? save some lives by surrendering (you lose the game)");

            }
        });

        JButton button3 = new JButton("build silo"); // Create button


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "costs funds, more silos decrease the chance of enemy interception of your attacks");

            }
        });

        JButton button4 = new JButton("invade"); // Create button


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "force a nation to surrender, if you have sufficiently more divisions than the enemy");

            }
        });

        JButton button5 = new JButton("stealth strike"); // Create button


        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "deal a small blow to target population with a reduced chance of letting them know who attacked them");

            }
        });

        JButton button6 = new JButton("attack"); // Create button


        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "A large scale attack that may alert the target as to who attacked them");

            }
        });

        JButton button7 = new JButton("Build SAM"); // Create button


        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "increases your chance to intercept incoming attacks ");

            }
        });

        JButton button8 = new JButton("About"); // Create button


        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Version 0.0.0");

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

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(button5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(button6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(button7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(button8, gbc);





        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }



}
