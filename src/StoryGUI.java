import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;


public class StoryGUI {
    JFrame frame = new JFrame("While Other Nations Think");
    private boolean done;
    private String text;
    private int tVal;
    Dictionary<Integer,String> d = new Hashtable<>();
    public StoryGUI() {
        done = false;

        tVal = 0;

        d.put(0,"You Turn on the news, after all tonight is the big night.");
        d.put(1,"The televisons slightly blurry picture starts to clear");
        d.put(2,"The Ads end and the camera cuts to the news reporter.");
        d.put(3,"* and the results are in! We now know with certainty who won the election*");
        d.put(4,"you are shocked to see your party won");
        d.put(5,"wouldn't that make you in charge?");
        d.put(6,"...");
        d.put(7,"***2 months later***");
        d.put(8,"intelligence shows that many other nations are making drastic increases on military spending");
        d.put(9,"Further relationships from all nations are souring");
        d.put(10,"This can't be good");


        frame.setSize(400, 300);  // Set the frame's size




        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  // dont close window




        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing

        JMenuBar menuBar = new JMenuBar();
        JMenu textMenu = new JMenu("Fwd/Back");
        JMenuItem next = new JMenuItem("Next");
        JMenuItem back = new JMenuItem("Back");

        textMenu.add(next);
        textMenu.addSeparator();
        textMenu.add(back);
        menuBar.add(textMenu);


        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tVal >= 11){
                    frame.setVisible(false);
                    done = true;
                }

                else {
                    frame.setVisible(false);
                    tVal += 1;
                    setUpFrame();
                    frame.setVisible(true);
                }
            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tVal < 1){
                    System.out.println("tVal should not be negative.");
                }

                else {
                    tVal -= 1;
                    setUpFrame();
                }
            }
        });
        frame.setJMenuBar(menuBar);


        setUpFrame();



        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }

    public boolean isDone() {
        return done;
    }

    public void setUpFrame(){
        text = d.get(tVal);

        JLabel label = new JLabel(text);


        GridBagConstraints gbc = new GridBagConstraints(); // Set up GridBagConstraints to control the placement and resizing of buttons


        gbc.fill = GridBagConstraints.BOTH;  // Resizes both horizontally and vertically
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add buttons to the frame using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);









    }
}
