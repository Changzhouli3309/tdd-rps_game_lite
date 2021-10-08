package service;

import model.Game;
import model.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sevice.GameService;
import util.RandomMove;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameServiceTest {

    private GameService gameService;
    private RandomMove randomMove;

    @BeforeEach
    void setUp() {
        randomMove = mock(RandomMove.class);
        gameService = new GameService(randomMove);
    }

    @Test
    void getRandomAiMove_test() {
        // Given
        when(randomMove.getRandomAiMove()).thenReturn("ROCK");
        // When
        String move = gameService.getRandomAiMove();
        // Then
        assertEquals("ROCK", move);
    }

    @ParameterizedTest
    @MethodSource("argsForRoundRes")
    void getRoundRes_test(String expected, String playerMove, String aiMove) {

        assertEquals(expected, gameService.getRoundRes(playerMove, aiMove));
    }

    private static Stream<Arguments> argsForRoundRes() {
        //String expected, String playerMove, String aiMove
        return Stream.of(
                Arguments.of("DRAW", "ROCK", "ROCK"),
                Arguments.of("LOSE", "ROCK", "PAPER"),
                Arguments.of("WIN", "ROCK", "SCISSORS"),
                Arguments.of("DRAW", "SCISSORS", "SCISSORS"),
                Arguments.of("WIN", "PAPER", "ROCK"),
                Arguments.of("LOSE", "SCISSORS", "ROCK")

        );
    }

    @ParameterizedTest
    @MethodSource("argsForMoveNumber")
    void getMoveNumber_test(int expected, String move) {
        assertEquals(expected, gameService.getMoveNumber(move));
    }

    private static Stream<Arguments> argsForMoveNumber() {
        //String expected, String playerMove, String aiMove
        return Stream.of(
                Arguments.of(0, "ROCK"),
                Arguments.of(1, "PAPER"),
                Arguments.of(2, "SCISSORS")
        );
    }

    @Test
    void getMoveNumber_exception_test() {
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, ()
                -> gameService.getMoveNumber("test"));
        assertEquals("Illegal move", actual.getMessage());
    }

    @Test
    void updateScore_test() {
        Game actual = new Game(3);
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual.getRounds().add(new Round("SCISSORS", "ROCK", "LOSE"));

        actual = gameService.updateScore(actual);

        assertEquals(2, actual.getWin());
        assertEquals(1, actual.getLose());
    }

    @Test
    void isGameEnd_false_test() {
        Game actual = new Game(3);
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual.getRounds().add(new Round("SCISSORS", "ROCK", "LOSE"));

        actual = gameService.updateScore(actual);

        assertFalse(gameService.isGameEnd(actual));
    }

    @Test
    void isGameEnd_true_test() {
        Game actual = new Game(2);
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual = gameService.updateScore(actual);

        assertTrue(gameService.isGameEnd(actual));
    }

    @Test
    void getGameRes_win_test() {
        Game actual = new Game(1);
        actual.getRounds().add(new Round("ROCK", "SCISSORS", "WIN"));
        actual = gameService.updateScore(actual);
        actual = gameService.getGameRes(actual);

        assertEquals("You win the game.", actual.getResult());

    }

    @Test
    void getGameRes_loss_test() {
        Game actual = new Game(1);
        actual.getRounds().add(new Round("SCISSORS", "ROCK", "LOSE"));
        actual = gameService.updateScore(actual);
        actual = gameService.getGameRes(actual);

        assertEquals("You lose the game.", actual.getResult());
    }

}