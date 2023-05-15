package Application;

import Utility.UI;

import java.util.ArrayList;
import java.util.List;

public class Application {

    List<String> options = new ArrayList<>();
    private String welcomeMessage = "Welcome!";
    UI ui = new UI();

    public Application(){
        mainMenu();
    }


    public void mainMenu(){
        List<String> options = new ArrayList<>();
        options.add("Show meal plan");
        options.add("create meal plan");
        ui.displayMessage(welcomeMessage);
        ui.displayMenu(options);

    }

    public void showMealPlan(){
        System.out.println("Finish the method please");
    }

    public void createMealPlan(){
        System.out.println("Finish the method please");
    }
}
