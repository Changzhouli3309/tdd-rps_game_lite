package client;

import model.Game;
import model.Round;
import sevice.GameService;
import util.UserInput;

public class RpsGameClient {
    private final UserInput userInput;
    private final GameService gameService;

    public RpsGameClient(UserInput userInput, GameService gameService) {
        this.userInput = userInput;
        this.gameService = gameService;
    }

    public Game createGame() {
        System.out.println("Set score limit");
        int scoreLimit = userInput.getInt();

        while (scoreLimit <= 0) {
            System.out.println("score limit must higher than 0");
            scoreLimit = userInput.getInt();
        }
        return new Game(scoreLimit);
    }

    public void makeMove(Game game) {
        System.out.println("\nChose your move:(ROCK,PAPER,SCISSORS)");
        String playerMove = userInput.getInputFromList("ROCK", "PAPER", "SCISSORS");

        String aiMove = gameService.getRandomAiMove();
        String result = gameService.getRoundRes(playerMove, aiMove);
        Round round = new Round(playerMove, aiMove, result);

        game = gameService.addRoundToList(game, round);
        game = gameService.updateScore(game);

        System.out.println("Round " + gameService.getListSize(game)
                + "\nPlayer: " + playerMove + " CPU: " + aiMove);
        System.out.println(result.equals("DRAW") ? "It is a draw." : "You " + result + " this round.");
        System.out.println("Player Stats: win: " + game.getWin() + "/" + game.getScoreLimit()
                + " lose: " + game.getLose() + "/" + game.getScoreLimit());
    }

    public boolean isGameEnd(Game game) {
        if (gameService.isGameEnd(game)) {
            System.out.println();

            game = gameService.getGameRes(game);

            System.out.println(game.getResult());
            System.out.println("-------log--------");
            game.getRounds().forEach(System.out::println);
            return true;
        }
        return false;
    }
}
