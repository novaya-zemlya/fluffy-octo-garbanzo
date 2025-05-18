import java.security.PublicKey;
import java.util.ArrayList;


public class Globe {
    public static int currentCycle; // used to measure the current cycle of everything
    public static ArrayList<Nation> nationList = new ArrayList<>(); // creates a 'global' list of all nations
    public static Nation moving;
    public static int populationStart;


    public void addNation (Nation n){
        nationList.add(n);
    } // add a nation to the list


    public void cycle(){
        currentCycle++;
    } // increase the currentCycle

    public int getCurrentCycle() {
        return currentCycle;
    } // returns the currentCycle

    // print the name of all nations in nationlist
    public void printNations(){
        for (Nation n : nationList){
            System.out.println(n.getName());
        }
    }


// print the stats of all the nations in nationlist
    public void printAllNationStats(){
        for (Nation n : nationList){
            n.printNationStat();
        }
    }

    public void setMoving (Nation moving){
        this.moving = moving;
    }

    public Nation getMoving(){
        return moving;
    }

}
