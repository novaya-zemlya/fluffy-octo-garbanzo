
public class Nation {
    private String name; //the name
    private boolean done; // if the nation has lost
    private double pop; // the population
    private int divisions;// the number of "land forces"
    private boolean war; // if the nation is at war
    private Nation enemy; // the enemy of the nation
    private int hits; // how many times a nation has been hit
    private int sCount; // the number of silos the nation has
    protected static int nations; // number of total nations
    private double damageMod; // the damage modifier of the nation
    private double detectionMod; // the detection modifier of the nation (used to lean who attacked the nation)
    private int money; // the money a nation has
    private int income;// the amount the money is increased by each cycle
    private boolean occupied;// if the nation is occupied
    private double interceptMod; // the modifier to intercept missiles
    private boolean hen; // used to know is a nation surrendered
    private int nationCycle; // the nations cycle

    public Nation (String name,int pop, int divisions, int sCount){ // create a nation
        this.name = name;
        this.pop = (double) pop;
        this.divisions = divisions;
        this.sCount = sCount;
        war = false;
        hits = 0;
        enemy = null;
        nations++;
        damageMod = 1;
        detectionMod = 1;
        money = 10000;
        occupied = false;
        interceptMod = 0.3;
        income = 100;
        hen = true;
    }

    public int getPop() {
        return (int) pop;
    } //get the population of the nation

    private Nation hit(Nation attacker){ // nation takes a small hit, caused a loss in population
        war = true;
        boolean a = Math.random() > 0.5 * detectionMod;
        enemy = (a) ? (attacker) : (this.enemy);
        pop /= (3 * damageMod);
        return enemy;
    }
    private Nation majorHit(Nation attacker){// nation takes a large hit if not intercepted
        war = true;
        damageMod -= 0.2;
        boolean a = Math.random() > 0.2 * detectionMod;
        enemy = (a) ? (attacker) : (this.enemy);
        if (Math.random() * sCount * 3 > attacker.interceptMod * 0.5){
            System.out.println("Attack success");
            pop /= 5;
        }
        else{
            System.out.println("Attack intercepted");
        }
        return enemy;
    }

    public void setHen(boolean hen) { // set the hen status of the nation (used to know if it lost)
        this.hen = hen;
    } // 🐖

    public String attack(Nation target){ // attacks target with a major hit
      /*  if (pop < 1000 || done){
            return "cannot attack";
        }
*/
        target.majorHit(this);
/*
        try{
            target.majorHit(this);
        } catch (Exception e) {
            return "no such nation";
        }
*/
        return "Launched attack on: " + target.toString();
    }
    public String stealthStrike(Nation target, Nation attacker){ //attacks target with hit (small chance of detection)
        if (done)
            return "cannot attack";

        target.hit(attacker);
        this.enemy = target;

        /*try{
            target.hit(attacker);
            this.enemy = target;
        } catch (NullPointerException e) {
            return "no such nation";
        }
         */

        return "Launched";
    }
    public String invade(Nation target){ //uses divisions to attempt and invade target nation
        if (divisions > target.divisions * 2){
            target.done = true;
            divisions -= target.divisions;
            pop += target.pop / 2;
            sCount = 0;
            return "success";
        }
        divisions = 0;
        pop /= 1.2;
        return "failed";

    }
    public void declareWar(Nation target){ // declare war on target, setting war to true and establishing an enemy
        war = true;
        enemy = target;
        target.setEnemy(this);
        damageMod -= 0.5;
        target.damageMod -= 0.5;
        detectionMod += 0.3;
        target.detectionMod += 0.3;
    }
    public void surrender(){
        done = true;
    } //surrender and lose
    public String buildDivision(){ // build a division
        if (money > 250){
            divisions++;
            money -= 250;
            return "built";
        }
        return "cannot afford";
    }
    public String sellDivision(){// sell a division
        if( divisions > 0){
            divisions --;
            money += 100;
            return "sold";
        }
        return "no division to sell";
    }

    public String buildSilo(){ // build a silo
        if (money > 550){
            sCount++;
            money -= 550;
            return "built";
        }
        return "cannot afford";
    }

    public void printNationStat(){ //print out the stats of the nation
        System.out.println(name);

        for (int i = 0; i < name.length()-1; i++){
            System.out.print("*");
        }
        System.out.println("*");
        System.out.println("population: " + pop);
        System.out.println("Funds: " + money);
        System.out.println(" ");
    }

    public void fundRaise(){
        income += 25;
    }// increase the income

    public String getName() {
        return name;
    }// return the name of nation

    public int getNationCycle() {
        return nationCycle;
    }// return the nation cycle

    public void increaseNationCycle(){// increase the nationcycle and cause money to be added
        nationCycle++;
        cycleMoney();
    }

    public void setMoney(int money) {
        this.money = money;
    } // set the money of the nation

    public int getMoney() {
        return money;
    } // return the nation's money
    public void cycleMoney(){
        money += income;
    } // increase the nation's money by income

    public boolean isDone() {
        return done;
    } // return if the nation has surrendered

    public boolean isWar() {
        return war;
    }// return if the nation is at war

    public boolean isHen(){ // return if the nation cannot make a move
        return hen;
    }

    public void setEnemy(Nation enemy){
        this.enemy = enemy;
    } //set the nation's enemy

    public Nation getEnemy() {
        return enemy;
    } // return the nation's enemy

    public void updateEnemy(){ // if enemy is defeated set enemy to nothing
        try {
            System.out.println(name + " has enemy: " + enemy.toString());
            if (!enemy.isHen() || enemy.isDone()){
                this.enemy = null;
                war = false;
            }
        } catch (NullPointerException e) {
            System.out.println("no enemy");
        }



    }

    public void buildSAM (){ // build a SAM
        if (money > 500){
            interceptMod *= 1.1;
            money -= 500;
        }

    }

    public int getDivisions(){ // return the number of divisions
        return divisions;
    }

    public void setDone(boolean done){ // set the done status
        this.done = done;
    }


    @Override
    public String toString() { // print the nations name
        return name;
    }
}

