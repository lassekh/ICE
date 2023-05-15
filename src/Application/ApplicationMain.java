package Application;

import User.AccountHandler;

public class ApplicationMain {

    public static void main(String[] args) {
        AccountHandler accountHandler = new AccountHandler();
        accountHandler.mainMenu();

        Application application = new Application();
        application.menu();


    }
}
