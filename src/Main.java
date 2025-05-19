
import java.sql.Time;
import java.util.Scanner;
//hello
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AudioCont introMusic = new AudioCont();
        introMusic.playSoundLoop("107330__chimerical__countdown-news-intro.wav");


        StoryGUI story = new StoryGUI();
        while (!story.isDone()){
            Thread.sleep(0);
        }


        MenuMk2 intro = new MenuMk2(); // create and start the intro GUI
        while (!intro.isStart()){
            Thread.sleep(0); // ide no like this
        }
        introMusic.stopSound();

        Menu start = new Menu(); // create a menu
        AutoTurn chooser = new AutoTurn(); // create an autoTurn
        start.setName("human"); // used to set player name
        Globe world = new Globe(); // create 'globe' to hold all nations
        Nation human = new Nation(start.getName(), 1000000,2,0); // human nation
        Nation canada = new Nation("Canada",500000,1,1); // canada
        Nation uk = new Nation("UK",1000000,3,0); // uk
        Nation turkey = new Nation("Turkey",400000,2,1); // turkey
        Nation uae = new Nation("UAE", 300000,1,0); // uae
        Nation india = new Nation("India",700000,2,1); // india

        // add nations into globe
        world.addNation(human);
        world.addNation(canada);
        world.addNation(uk);
        world.addNation(turkey);
        world.addNation(uae);
        world.addNation(india);

        // test functions
        world.printNations();
        world.printAllNationStats();
        start.startGUI();
        world.cycle();
// real game stuff
        System.out.println(human.isDone());
        while (!human.isDone()){ // while player has not surrendered

            int cCycle = human.getNationCycle(); // current cycle

            start.GUIOff();
            System.out.println("GUI OFF");

            int moves = 1;
            System.out.println(moves/Globe.currentCycle);
            while (moves/Globe.currentCycle == 1) {
                for (Nation n : Globe.nationList) { // for every nation in the globe
                    System.out.println(n + " is making move");
                    if (Settings.doWait) {
                        world.setMoving(n);
                        WaitGUI wait = new WaitGUI();
                        chooser.makeMove(n);
                        moves += n.getNationCycle();
                        n.updateEnemy();
                        System.out.println();
                        Thread.sleep(Settings.speed * 1000);
                        wait.GUIOff();
                        if (AutoTurn.notWar){
                            start.notWar();
                        }
                    }
                    else {
                        chooser.makeMove(n);
                        moves += n.getNationCycle();
                        n.updateEnemy();
                        if (AutoTurn.notWar){
                            start.notWar();
                        }
                        System.out.println();
                        Thread.sleep(Settings.speed * 1000);
                    }
                }
            }
            System.out.println("GUI ON");
            start.startGUI();
            while (human.getNationCycle() <= cCycle){ //until player makes move
                Thread.sleep(0); // might not be needed
            }





        }
        start.GUIOff();

    }


}