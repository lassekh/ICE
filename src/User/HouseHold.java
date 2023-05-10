package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HouseHold {

    List<String> names = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createMember(){
        System.out.println("Welcome. Whats the first name?");
        String s = scanner.nextLine();
        names.add(s);
    }


}
