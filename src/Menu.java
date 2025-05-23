import java.util.Scanner;

public class Menu {
    MenuGUI GUI; // create a variable for the GUI
    private String name; // the name of the menu (also player name)
    private Scanner kb = new Scanner(System.in);// keyboard scanner

    public Menu(){

//🐖🐖🐖

    }

    public void setName() { //set the name of the menu via scanner
        System.out.println("enter name: ");
        this.name = kb.nextLine();
    }

    public void setName(String name){ // set the name of the menu directly
        this.name = name;
    }

    public void startGUI(){ // create a new GUI
        MenuGUI turn = new MenuGUI();
        this.GUI = turn;
    }

    public void GUIOff(){ // turn the GUI off
        GUI.GUIOff();

    }

    public void GUIFreeze(){ // does nothing right now
       // this.GUI

    }





    public String getName() { // returns the menu name
        return name;
    }


    public void notWar(){ // notify if there is a war
        GUI.notifyWar();
    }

    public void evalEnd() throws InterruptedException{ // check if the game should end
        if (Globe.numHostileNations() < 1 || Globe.nationList.getFirst().isDone()){
            EndGUI end = new EndGUI();
        }
    }
}