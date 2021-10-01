package util;

import java.util.Random;

public class RandomMove {

    private final String[] moves;
    private final Random ran;

    public RandomMove() {
        this.moves = new String[]{"ROCK", "PAPER", "SCISSORS"};
        this.ran = new Random();
    }

    public String getRandomAiMove() {
        return moves[getRandomNumber(2, 0)];
    }

    public int getRandomNumber(int max, int min) {
        return ran.nextInt(max - min + 1) + min;
    }

}

