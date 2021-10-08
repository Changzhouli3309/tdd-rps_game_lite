package clent;

import model.Game;
import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sevice.GameService;
import util.RandomMove;
import util.UserInput;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RpsGameClentTest {

    private RpsGameClent rpsGameClent;
    private UserInput userInput;
    private RandomMove randomMove;
    private String[] moveList;

    @BeforeEach
    void setUp() {
        userInput = mock(UserInput.class);
        randomMove = mock(RandomMove.class);

        GameService gp = new GameService(randomMove);

        rpsGameClent = new RpsGameClent(userInput, gp);

        moveList = new String[]{"ROCK", "PAPER", "SCISSORS"};
    }

    @Test
    void createGame_test(){

        when(userInput.getInt()).thenReturn(2);

        Game game = rpsGameClent.createGame();

        assertEquals(2, game.getScoreLimit());

    }

    @Test
    void makeMove_test(){

        when(userInput.getInputFromList(moveList)).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("ROCK");

        Game game = new Game(3);

        rpsGameClent.makeMove(game);

        Round actual = game.getRounds().get(0);

        assertEquals("ROCK",actual.getPlayerMove());
        assertEquals("ROCK",actual.getAiMove());
        assertEquals("DRAW" , actual.getResult());
    }

    @Test
    void getResult_turn_test(){

        when(userInput.getInt()).thenReturn(2);

        Game game = rpsGameClent.createGame();

        when(userInput.getInputFromList(moveList)).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("SCISSORS");

        rpsGameClent.makeMove(game);

        assertFalse(rpsGameClent.isGameEnd(game));

        when(userInput.getInputFromList(moveList)).thenReturn("PAPER");
        when(randomMove.getRandomAiMove()).thenReturn("ROCK");

        rpsGameClent.makeMove(game);

        assertTrue(rpsGameClent.isGameEnd(game));
    }
}
