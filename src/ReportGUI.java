import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class ReportGUI {
    JFrame frame = new JFrame("Report"); // name of the window
    public ReportGUI() {

        frame.setSize(400, 300);  // Set the frame's size




        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Dont end the whole game when closed




        frame.setLayout(new GridBagLayout()); // Use GridBagLayout thing

        Nation player = Globe.nationList.getFirst(); // get the player

        StringBuilder nationslLeft = new StringBuilder(); //intellej says string builder is better than +=

        for (Nation n : Globe.nationList){
            if (!n.isDone()){
                if (n.equals(Globe.nationList.getFirst())){
                    System.out.println("Nation: " +n +" is human, will not add to hostile list");
                }
                else {
                nationslLeft.append(n);
                nationslLeft.append(" ");}
            }
        }

        //JLabel label = new JLabel(player + " Remaining population: " + player.getPop() +n+ "");
        JLabel label = new JLabel("<html> Nation: "+ player +"<br/> Remaining population: "+ player.getPop() +"<br/> Funds: "+player.getMoney() +"<br/> Divisions: "+player.getDivisions() + "<br/> Hostile Nations Remaining: " + nationslLeft+ "<br/> Report issued on cycle: " + player.getNationCycle()+" <br/> Current global population: "+ Globe.getGlobePop() +"</html>", SwingConstants.CENTER);
        //System.out.println(Globe.populationStart);
        //System.out.println("get globe pop: "+Globe.getGlobePop());





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
