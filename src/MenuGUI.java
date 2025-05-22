import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MenuGUI {
    JFrame frame = new JFrame("Stuff"); // new window
    private Nation target; // the targeted nation
    private static String name; // the name of the player

    public MenuGUI() {




        frame.setSize(400, 300);  // Set the frame's size


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // end game on close

        JMenuBar menuBar = new JMenuBar();
        JMenu targetMenu = new JMenu("Target");
        JMenuItem openItem = new JMenuItem("CANADA");
        JMenu otherMenu = new JMenu("More");

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 for (Nation n : Globe.nationList){
                     if ( n.toString().equals("Canada")){
                         target = n;
                         JOptionPane.showMessageDialog(frame, "Targeted: " + target.toString());
                     }
                 }
            }
        });
        JMenuItem exitItem = new JMenuItem("UK");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Nation n : Globe.nationList){
                    if ( n.toString().equals("UK")){
                        target = n;
                        JOptionPane.showMessageDialog(frame, "Targeted: " + target.toString());
                    }
                }
            }
        });

        JMenuItem turkey = new JMenuItem("TURKEY");

        turkey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Nation n : Globe.nationList){
                    if ( n.toString().equals("Turkey")){
                        target = n;
                        JOptionPane.showMessageDialog(frame, "Targeted: " + target.toString());
                    }
                }
            }
        });
        JMenuItem uae = new JMenuItem("UAE");

        uae.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Nation n : Globe.nationList){
                    if ( n.toString().equals("UAE")){
                        target = n;
                        JOptionPane.showMessageDialog(frame, "Targeted: " + target.toString());
                    }
                }

            }
        });

        JMenuItem india = new JMenuItem("INDIA");
        india.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Nation n : Globe.nationList){
                    if ( n.toString().equals("India")){
                        target = n;
                        JOptionPane.showMessageDialog(frame, "Targeted: " + target.toString());
                    }
                }
            }
        });

        JMenuItem settings = new JMenuItem("Settings");
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings op = new Settings();
            }
        });

        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About ab = new About();
            }
        });

        JMenuItem report = new JMenuItem("Status report");
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportGUI r = new ReportGUI();
                System.out.println("report clicked, this does nothing for now");
            }
        });

        // target menu setup
        targetMenu.add(openItem);
        targetMenu.addSeparator();
        targetMenu.add(exitItem);
        targetMenu.addSeparator();
        targetMenu.add(turkey);
        targetMenu.addSeparator();
        targetMenu.add(uae);
        targetMenu.addSeparator();
        targetMenu.add(india);
        menuBar.add(targetMenu);

        // other menu setup
        otherMenu.add(settings);
        otherMenu.addSeparator();
        otherMenu.add(help);
        otherMenu.addSeparator();
        otherMenu.add(report);
        menuBar.add(otherMenu);


        frame.setLayout(new GridBagLayout()); // Use GridBagLayout


        JButton button1 = new JButton("Fundraise"); // Create button


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Nation player = Globe.nationList.getFirst();
                player.fundRaise();

                System.out.println("Fundraise clicked");
                player.printNationStat();
                player.increaseNationCycle();


            }
        });


        JButton button2 = new JButton("Surrender"); // Create the second button


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Nation player = Globe.nationList.getFirst();
                player.surrender();
                System.out.println("shame");
                System.out.println(player.isDone());
                player.increaseNationCycle();
            }
        });




        JButton button3 = new JButton("Attack"); //more buttons
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nation player = Globe.nationList.getFirst();
                    player.attack(target);
                    notifyWar();
                    player.increaseNationCycle();
                }
                catch (NullPointerException u){
                    JOptionPane.showMessageDialog(frame, "No Target Selected");

                }

            }
        });

        JButton button4 = new JButton("Build Silo");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nation player = Globe.nationList.getFirst();
                player.buildSilo();
                player.increaseNationCycle();
            }
        });
        JButton button5 = new JButton("Build Division");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nation player = Globe.nationList.getFirst();
                player.buildDivision();
                player.increaseNationCycle();
            }
        });

        JButton button6 = new JButton("Sell Division");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Nation player = Globe.nationList.getFirst();
                player.sellDivision();
                player.increaseNationCycle();
            }
        });

        JButton button7 = new JButton("Declare War");
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nation player = Globe.nationList.getFirst();
                    /*if (player.isWar()){
                        JOptionPane.showMessageDialog(frame, "Already at War (max of 1 target allowed)");
                    }

                    else {
                    player.declareWar(target);
                    notifyWar();
                    player.increaseNationCycle();}

                     */

                    player.declareWar(target);
                    player.setEnemy(target);
                    notifyWar();
                    player.increaseNationCycle();



                }
                catch (NullPointerException u){
                    JOptionPane.showMessageDialog(frame, "No Target Selected");

                }

            }
        });

        JButton button8 = new JButton("Invade");
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nation player = Globe.nationList.getFirst();
                    String outcome = player.invade(target);
                    if (outcome.equals("failed")){
                        JOptionPane.showMessageDialog(frame, "Invasion Failed, we lost all our divisions.");
                    } else if (outcome.equals("success")) {
                        JOptionPane.showMessageDialog(frame, "Invasion success "+ target.toString() + " surrendered!");
                        JOptionPane.showMessageDialog(frame,"We have " + player.getDivisions() + "divisions remaining.");

                    }
                    notifyWar();
                    player.increaseNationCycle();
                }
                catch (NullPointerException u){
                    JOptionPane.showMessageDialog(frame, "No Target Selected");
                }

            }
        });

        JButton button9 = new JButton("StealthStrike");
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nation player = Globe.nationList.getFirst();
                    player.stealthStrike(target,player);
                    player.increaseNationCycle();
                    notifyWar();
                }
                catch (NullPointerException u){
                    JOptionPane.showMessageDialog(frame, "No Target Selected");
                }


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

        gbc.gridx = 1;
        gbc.gridy = 0;

        frame.add(button4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        frame.add(button5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;

        frame.add(button6, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;

        frame.add(button7, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;

        frame.add(button8, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;

        frame.add(button9, gbc);



        frame.setJMenuBar(menuBar);




        frame.setVisible(true); // Make the frame visible
    }
    public void GUIOff(){//make the frame not visible (turn off GUI)
        frame.setVisible(false);
    }

    public void notifyWar(){
        JOptionPane.showMessageDialog(frame, "You are at war with: " + Globe.nationList.getFirst().getEnemy().toString());
    }

    public static void setName(){
        name =  JOptionPane.showInputDialog("Enter Nation Name");
    }

    public static String getName() {
        return name;
    }
}
