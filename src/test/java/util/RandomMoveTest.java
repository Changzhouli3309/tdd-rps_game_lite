package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMoveTest {

    private final RandomMove randomMove = new RandomMove();

    @Test
    void getRandomAiMove_test() {

        for (int i = 0; i < 30; i++) {
            String actual = randomMove.getRandomAiMove();
            assertTrue(actual.equals("ROCK")||actual.equals("PAPER")||actual.equals("SCISSORS"));
        }
    }
}