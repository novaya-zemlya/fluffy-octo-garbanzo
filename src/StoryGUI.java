import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;



public class StoryGUI {
    JFrame frame = new JFrame("Intro"); // the Jframe
    private boolean done; // if the story has been finished
    private String text; // the text that will be displayed on screen
    private int tVal; // used to know what the current text should be accessed.
    Dictionary<Integer,String> d = new Hashtable<>(); // dictionary to store the text
    private JLabel label; // the label used to display the text


    public StoryGUI() {
        done = false;

        tVal = 0;
        // TODO: make a good story 
        d.put(0,"You Turn on the news, after all tonight is the big night.");
        d.put(1,"The televison's slightly blurry picture starts to clear");
        d.put(2,"The ad ends and the camera cuts to the news reporter.");
        d.put(3,"*and the results are in! We now know with certainty who won the election*");
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
        JMenuItem skip = new JMenuItem("Skip");

        textMenu.add(next);
        textMenu.addSeparator();
        textMenu.add(back);
        textMenu.addSeparator();
        textMenu.add(skip);
        menuBar.add(textMenu);


        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tVal >= 10){
                    frame.setVisible(false);
                    done = true;
                }

                else {
                    frame.setVisible(false);
                    tVal += 1;
                    setUpFrame(true);
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
                    frame.setVisible(false);
                    tVal -= 1;
                    setUpFrame(true);
                    frame.setVisible(true);
                }
            }
        });

        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done = true;
                frame.setVisible(false);
            }
        });
        frame.setJMenuBar(menuBar);


        setUpFrame(false);



        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    } // turn off the GUI

    public boolean isDone() {
        return done;
    } // return if the story is finished

    public void setUpFrame(boolean clear){ // set up a new frame.

        if (clear){
            frame.remove(label); // if a label with text exists, clear it
        }

        text = d.get(tVal);

        this.label = new JLabel(text);




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
