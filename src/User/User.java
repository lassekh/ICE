package User;

public class User {

    //Declaring two attributes regarding: User's name and age.
    private String name;
    private int age;

    //Public constructor with two parameters that creates a user.
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Method to get hold of the instance's name.
    public String getName(){
        return this.name;
    }

    //Method to get hold of the instance's age.
    public int getAge(){
        return this.age;
    }


}
