import org.junit.jupiter.api.Test;
import util.InputChecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputCheckTest {

    private static final InputChecker inputChecker= new InputChecker();

    @Test
    void checkInt_test() {
        assertTrue(inputChecker.checkInt("1244"));
        assertTrue(inputChecker.checkInt("1244"));
        assertTrue(inputChecker.checkInt("1244"));
        assertFalse(inputChecker.checkInt("3e1"));
        assertFalse(inputChecker.checkInt("test"));
        assertFalse(inputChecker.checkInt("try"));
    }

    @Test
    void cHeckMove_test() {
        //ROCK,PAPER,SCISSORS
        assertTrue(inputChecker.checkMove("ROCK"));
        assertTrue(inputChecker.checkMove("PAPER"));
        assertTrue(inputChecker.checkMove("SCISSORS"));
        assertFalse(inputChecker.checkMove("RoCK"));
        assertFalse(inputChecker.checkMove("PaPeR"));
        assertFalse(inputChecker.checkMove("test"));
    }
}