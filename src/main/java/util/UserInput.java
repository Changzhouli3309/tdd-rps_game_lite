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

    public int getInt(){
        while (true){
            try {
                return Integer.parseInt(getInput());
            }catch (NumberFormatException e){
                System.out.println("Input is not a Integer.");
            }
        }
    }

    public String getInputFromList(String ...list){
        while (true){
            String input = getInput();
            for (String s: list) {
                if (s.equals(input))
                    return input;
            }
            System.out.println("Input is not allowed");
        }
    }
}
