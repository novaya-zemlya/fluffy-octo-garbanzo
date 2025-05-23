
import java.util.Random;

public class AutoTurn {
    public static boolean notWar; // if a notification should be sent
    public void makeMove(Nation n) {
        notWar = false;
        if (n.isHen() && ! n.getName().equals(Globe.nationList.getFirst().getName())) { //check if nation can make move
            if (n.isWar()) { // check if nation is at war
                if (n.getPop() < 1000) { // check if nation has enough people to keep the fight going
                    n.surrender();
                    System.out.println(n + " Lost!");
                    n.setHen(false);
                }
                if (n.getEnemy() != null) {
                    int warMove = (int) (Math.random()*(2-1))+1;
                    if (warMove == 1) {
                        n.attack(n.getEnemy());
                        System.out.println("attacked");
                    } else if (warMove == 2) {
                        n.invade(n.getEnemy());
                        System.out.println("invaded");
                    }
                }
            } else if (n.getPop() < 1000) {
                n.surrender();
                System.out.println(n + " Lost!");
                n.setHen(false);
                System.out.println("Surrender");
            } else {
                int move = (int) (Math.random()*(6)+1);
                if (move == 1) {
                    n.fundRaise();
                    n.increaseNationCycle();
                    System.out.println("fundraise");
                } else if (move == 2) {
                    if (n.buildSilo().equals("cannot afford")) {
                        n.fundRaise();
                        System.out.println("fundraise");

                    }
                    System.out.println("builtSilo");
                    n.increaseNationCycle();
                } else if (move == 3) {
                    if (n.buildDivision().equals("cannot afford")) {
                        n.fundRaise();
                        System.out.println("fundraise");
                    }
                    n.increaseNationCycle();
                } else if (move == 4) {
                    do {
                        n.declareWar(Globe.nationList.get((int) ((Math.random() * (Globe.nationList.size()) ))));
                    } while (n.getEnemy().equals(n));
                    if (n.getEnemy().equals(Globe.nationList.getFirst())){
                        notWar = true;
                        AudioCont.playAlarm();

                    }
                    n.increaseNationCycle();
                    System.out.println("declared war");

                } else if (move == 5) {
                    Nation target = (Globe.nationList.get((int) ((Math.random() * (Globe.nationList.size()-1)))));
                    while (target.equals(n)){
                        target = (Globe.nationList.get((int) ((Math.random() * (Globe.nationList.size()-1)))));
                    }
                    if (target.equals(Globe.nationList.getFirst())){
                        notWar = true;
                        AudioCont.playAlarm();
                    }
                    n.stealthStrike(target,n);
                    n.increaseNationCycle();
                    System.out.println("Stealth strike");
                } else if (move == 6) {
                    n.fundRaise();
                    n.increaseNationCycle();
                    System.out.println("fundraise");
                } else if (move == 7 && n.getMoney() < 500) {
                    n.sellDivision();
                    n.increaseNationCycle();
                    System.out.println("sold division");
                } else if (move == 8) {
                    Nation target = (Globe.nationList.get((int) ((Math.random() * (Globe.nationList.size()-1)+1))));
                    while (target.equals(n)){
                        target = (Globe.nationList.get((int) ((Math.random() * (Globe.nationList.size()-1)+1))));
                    }
                    if (target.equals(Globe.nationList.getFirst())){
                        notWar = true;
                        AudioCont.playAlarm();
                    }
                    n.attack(target);
                    n.increaseNationCycle();
                    System.out.println("Stealth strike");

                } else {
                    n.fundRaise();
                    n.increaseNationCycle();
                    System.out.println("Other picked, fundraise");
                }


            }


        } else if (n.getName().equals(Globe.nationList.getFirst().getName())) {
            System.out.println("nation " + n +" is human, no auto turn to make");
        } else {
            System.out.println(n + "surrendered, cannot move");

        }
    }
}
