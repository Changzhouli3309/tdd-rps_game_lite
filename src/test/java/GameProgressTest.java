import model.Game;
import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sevice.GameProgress;
import util.RandomMove;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameProgressTest {

    private GameProgress gp;
    private RandomMove randomMove;

    @BeforeEach
    void setUp() {
        randomMove = mock(RandomMove.class);
        gp = new GameProgress(randomMove);
    }

    @Test
    void getRandomAiMove_test() {

        when(randomMove.getRandomAiMove()).thenReturn("ROCK");

        String move = gp.getRandomAiMove();
        assertEquals("ROCK", move);
    }

    @Test
    void getRoundRes_test() {
        assertEquals("DRAW", gp.getRoundRes("ROCK", "ROCK"));
        assertEquals("WIN", gp.getRoundRes("ROCK", "SCISSORS"));
        assertEquals("LOSE", gp.getRoundRes("ROCK", "PAPER"));
        assertEquals("DRAW", gp.getRoundRes("SCISSORS", "SCISSORS"));
        assertEquals("WIN", gp.getRoundRes("PAPER", "ROCK"));
        assertEquals("LOSE", gp.getRoundRes("SCISSORS", "ROCK"));
    }

    @Test
    void getMoveNumber_test() {
        assertEquals(0, gp.getMoveNumber("ROCK"));
        assertEquals(1, gp.getMoveNumber("PAPER"));
        assertEquals(2, gp.getMoveNumber("SCISSORS"));
    }

    @Test
    void updateScore_test(){
        Game actual =new Game(3);
        actual.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual.getRounds().add(new Round("SCISSORS","ROCK","LOSE"));

        actual = gp.updateScore(actual);

        assertEquals(2,actual.getWin());
        assertEquals(1,actual.getLose());
    }
    @Test
    void isGameEnd_test() {
        Game actual =new Game(3);
        actual.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual.getRounds().add(new Round("SCISSORS","ROCK","LOSE"));

        actual = gp.updateScore(actual);

        assertFalse(gp.isGameEnd(actual));

        actual.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual = gp.updateScore(actual);

        assertTrue(gp.isGameEnd(actual));
    }

    @Test
    void getGameRes_test() {
        Game actual1 =new Game(1);
        actual1.getRounds().add(new Round("ROCK","SCISSORS","WIN"));
        actual1 = gp.updateScore(actual1);
        actual1 = gp.getGameRes(actual1);

        assertEquals("You win the game.",actual1.getResult());

        Game actual2 =new Game(1);
        actual2.getRounds().add(new Round("SCISSORS","ROCK","LOSE"));
        actual2 = gp.updateScore(actual2);
        actual2 = gp.getGameRes(actual2);

        assertEquals("You lose the game.",actual2.getResult());
    }

}