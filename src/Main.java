import User.Account;
import Utility.DBUser;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args){

        DBUser dbUser = new DBUser();

        Set<Account> accounts = new HashSet<>();

        accounts = dbUser.readUserData();

        System.out.println(accounts);




    }

}
