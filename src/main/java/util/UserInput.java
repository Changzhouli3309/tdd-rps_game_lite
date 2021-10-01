package util;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput(){
        this.scanner= new Scanner(System.in);
    }

    public String getInput(){
        return scanner.nextLine();
    }
}
