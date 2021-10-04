package controller;

import model.Game;
import model.Round;
import sevice.GameProgress;
import util.UserInput;

public class RpsGame {
    private final UserInput userInput;
    private final GameProgress gp;

    public RpsGame(UserInput userInput, GameProgress gp) {
        this.userInput = userInput;
        this.gp = gp;
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

    public Game makeMove(Game game) {
        System.out.println("\nyou move:(ROCK,PAPER,SCISSORS)");
        String playerMove = userInput.getInputFromList("ROCK", "PAPER", "SCISSORS");

        String aiMove = gp.getRandomAiMove();
        String result = gp.getRoundRes(playerMove, aiMove);
        Round round = new Round(playerMove, aiMove, result);

        System.out.println(round);

        game.getRounds().add(round);
        game = gp.updateScore(game);

        System.out.println("win: " + game.getWin() + " lose: " + game.getLose() + " limit: " + game.getScoreLimit());
        return game;
    }

    public boolean getResult(Game game) {
        if (gp.isGameEnd(game)) {
            System.out.println();

            game = gp.getGameRes(game);

            System.out.println(game.getResult());
            System.out.println("-------log--------");
            game.getRounds().forEach(System.out::println);
            return true;
        }
        return false;
    }
}
