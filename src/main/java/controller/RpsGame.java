package controller;

import model.Game;
import model.Round;
import sevice.GameProgress;
import util.InputChecker;
import util.UserInput;

public class RpsGame {
    private final UserInput userInput;
    private final GameProgress gp;
    private final InputChecker ic;

    public RpsGame(UserInput userInput, GameProgress gp, InputChecker ic) {
        this.userInput = userInput;
        this.gp = gp;
        this.ic = ic;
    }

    public Game createGame() {
        System.out.println("Set score limit");
        String scoreLimit = userInput.getInput();

        while (!ic.checkInt(scoreLimit)){
            System.out.println("Wrong input. Try again");
            scoreLimit = userInput.getInput();
        }

        return new Game(Integer.parseInt(scoreLimit));
    }

    public Game makeMove(Game game) {
        System.out.println("\nyou move:(ROCK,PAPER,SCISSORS)");
        String playerMove = userInput.getInput();

        while (!ic.checkMove(playerMove)){
            System.out.println("Wrong input. Try again");
            playerMove = userInput.getInput();
        }

        String aiMove = gp.getRandomAiMove();
        String result = gp.getRoundRes(playerMove,aiMove);
        Round round = new Round(playerMove,aiMove,result);

        System.out.println(round);

        game.getRounds().add(round);
        game = gp.updateScore(game);

        System.out.println("win: "+game.getWin()+" lose: "+game.getLose()+" limit: "+game.getScoreLimit());
        return game;
    }

    public boolean getResult(Game game) {
        if (gp.isGameEnd(game)){
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
