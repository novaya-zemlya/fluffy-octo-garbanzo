public class Nation {
    private String name;
    private boolean done;
    private double pop;
    private int divisions;
    private boolean war;
    private String enemy;
    private int hits;
    private int sCount;
    private static int nations;
    private double damageMod;
    private double detectionMod;
    private int money;
    private boolean occupied;
    private double interceptMod;
    private boolean isHen;

    public Nation (String name,int pop, int divisions, int sCount){
        this.name = name;
        this.pop = (double) pop;
        this.divisions = divisions;
        this.sCount = sCount;
        war = false;
        hits = 0;
        enemy = "none";
        nations++;
        damageMod = 1;
        detectionMod = 1;
        money = 10000;
        occupied = false;
        interceptMod = 0.3;
    }

    public int getPop() {
        return (int) pop;
    }

    private String hit(Nation attack){
        war = true;
        boolean a = Math.random() > 0.5 * detectionMod;
        enemy = (a) ? (attack.name) : ("unknown");
        pop /= (3 * damageMod);
        return enemy;
    }
    private String majorHit(Nation attack){
        war = true;
        damageMod -= 0.2;
        boolean a = Math.random() > 0.2 * detectionMod;
        enemy = (a) ? (attack.name) : ("unknown");
        if (Math.random() * sCount * 3 > attack.interceptMod * 2)
            pop /= 5;
        return enemy;
    }

    private void setHen(boolean hen) {
        isHen = hen;
    }

    public String attack(Nation target, Nation attacker){
        if (pop < 1000 || done){
            return "cannot attack";
        }

        try{
            target.majorHit(attacker);
        } catch (Exception e) {
            return "no such nation";
        }

        return "Launched";
    }
    public String stealthStrike(Nation target, Nation attacker){
        if (done)
            return "cannot attack";

        try{
            target.hit(attacker);
        } catch (Exception e) {
            return "no such nation";
        }

        return "Launched";
    }
    public String invade(Nation target){
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
    public void declareWar(Nation target){
        war = true;
        enemy = target.name;
        target.enemy = name;
        damageMod -= 0.5;
        target.damageMod -= 0.5;
        detectionMod += 0.3;
        target.detectionMod += 0.3;
    }
    public void surrender(){
        done = true;
    }
    public String buildDivision(){
        if (money > 150){
            divisions++;
            return "built";
        }
        return "cannot afford";
    }
    public String sellDivision(){
        if( divisions > 0){
            divisions --;
            money += 100;
            return "sold";
        }
        return "no division to sell";
    }

    public String buildSilo(){
        if (money > 300){
            sCount++;
            money -= 300;
            return "built";
        }
        return "not enough money";
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public void cycleMoney(){
        money += 100;
    }

    public boolean isDone() {
        return done;
    }
}

