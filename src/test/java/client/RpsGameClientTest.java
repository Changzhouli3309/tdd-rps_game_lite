package client;

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

public class RpsGameClientTest {

    private RpsGameClient rpsGameClient;
    private UserInput userInput;
    private RandomMove randomMove;
    private String[] moveList;

    @BeforeEach
    void setUp() {
        userInput = mock(UserInput.class);
        randomMove = mock(RandomMove.class);

        GameService gp = new GameService(randomMove);

        rpsGameClient = new RpsGameClient(userInput, gp);

        moveList = new String[]{"ROCK", "PAPER", "SCISSORS"};
    }

    @Test
    void createGame_test() {
        // Given
        when(userInput.getInt()).thenReturn(0,2);

        // When
        Game game = rpsGameClient.createGame();

        // Then
        assertEquals(2, game.getScoreLimit());
    }

    @Test
    void makeMove_test() {
        // Given
        when(userInput.getInputFromList(moveList)).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("ROCK");
        // When
        Game game = new Game(3);
        rpsGameClient.makeMove(game);
        Round actual = game.getRounds().get(0);

        // Then
        assertEquals("ROCK", actual.getPlayerMove());
        assertEquals("ROCK", actual.getAiMove());
        assertEquals("DRAW", actual.getResult());
    }

    @Test
    void getResult_true_test() {
        // Given
        when(userInput.getInt()).thenReturn(1);

        // When
        Game game = rpsGameClient.createGame();

        // Given
        when(userInput.getInputFromList(moveList)).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("SCISSORS");

        // When
        rpsGameClient.makeMove(game);

        // Then
        assertTrue(rpsGameClient.isGameEnd(game));
    }

    @Test
    void getResult_false_test() {
        // Given
        when(userInput.getInt()).thenReturn(2);

        // When
        Game game = rpsGameClient.createGame();

        // Given
        when(userInput.getInputFromList(moveList)).thenReturn("ROCK");
        when(randomMove.getRandomAiMove()).thenReturn("SCISSORS");

        // When
        rpsGameClient.makeMove(game);

        // Then
        assertFalse(rpsGameClient.isGameEnd(game));
    }
}
