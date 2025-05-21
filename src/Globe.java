import java.security.PublicKey;
import java.util.ArrayList;


public class Globe {
    public static int currentCycle; // used to measure the current cycle of everything
    public static ArrayList<Nation> nationList = new ArrayList<>(); // creates a 'global' list of all nations
    public static Nation moving; // the nation that is currently making a move
    public static int populationStart; // the starting population


    public void addNation (Nation n){
        nationList.add(n);
        populationStart += n.getPop();
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
    } // set the nations that is moving

    public Nation getMoving(){
        return moving;
    } // return the nation that is moving


    public static int getGlobePop(){// get the current total population of all nations
        int pop = 0;
        for (Nation n : nationList){
            pop +=n.getPop();
        }
        return pop;
    }

}
