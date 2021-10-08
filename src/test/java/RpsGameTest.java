import controller.RpsGame;
import model.Game;
import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sevice.GameProgress;
import util.RandomMove;
import util.UserInput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RpsGameTest {

    private RpsGame rpsGame;
    private UserInput userInput;
    private RandomMove randomMove;

    @BeforeEach
    void setUp() {
        userInput = mock(UserInput.class);
        randomMove = mock(RandomMove.class);

        GameProgress gp = new GameProgress(randomMove);

        rpsGame= new RpsGame(userInput, gp);
    }

    @Test
    void createGame_test(){

        when(userInput.getInt()).thenReturn(2);

        Game game = rpsGame.createGame();

        assertEquals(2, game.getScoreLimit());
        
    }

    @Test
    void makeMove_test(){

        when(userInput.getInputFromList("ROCK", "PAPER", "SCISSORS")).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("ROCK");

        Game game = new Game(3);

        game = rpsGame.makeMove(game);

        Round actual = game.getRounds().get(0);

        assertEquals("ROCK",actual.getPlayerMove());
        assertEquals("ROCK",actual.getAiMove());
        assertEquals("DRAW" , actual.getResult());
    }

    @Test
    void getResult_test(){

        when(userInput.getInt()).thenReturn(1);

        Game game = rpsGame.createGame();

        when(userInput.getInputFromList("ROCK", "PAPER", "SCISSORS")).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("SCISSORS");

        game = rpsGame.makeMove(game);

        assertTrue(rpsGame.getResult(game));
    }
}
