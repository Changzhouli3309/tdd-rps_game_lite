package util;

public class InputChecker {
    public boolean checkInt(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return  false;
        }
    }

    public boolean checkMove(String s){
        return s.equals("ROCK")||s.equals( "PAPER")||s.equals("SCISSORS");
    }
}
