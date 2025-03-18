import java.util.Scanner;

public class Menu {
    private String name;
    private Scanner kb = new Scanner(System.in);

    public void setName() {
        System.out.println("enter name");
        this.name = kb.nextLine();
    }


    public String getName() {
        return name;
    }
}