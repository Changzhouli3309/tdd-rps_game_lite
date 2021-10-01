package sevice;

import model.Game;
import model.Round;
import util.RandomMove;

import java.util.List;

public class GameProgress {
    private final String[] moves;
    private final String[] results;
    private final RandomMove randomMove;

    public GameProgress(RandomMove randomMove) {
        this.moves = new String[]{"ROCK", "PAPER", "SCISSORS"};
        this.results = new String[]{"DRAW", "WIN", "LOSE"};
        this.randomMove = randomMove;
    }

    public String getRandomAiMove() {
        return randomMove.getRandomAiMove();
    }

    public String getRoundRes(String playerMove, String aiMove) {
        int res = getMoveNumber(playerMove) - getMoveNumber(aiMove);
        if (res < 0) {
            res += 3;
        }
        return results[res];
    }

    public int getMoveNumber(String move) {
        for (int i = 0; i < moves.length; i++) {
            if (move.equals(moves[i])) return i;
        }
        throw new IllegalArgumentException("Illegal move");
    }

    public Game updateScore(Game game) {
        List<Round> rounds = game.getRounds();
        int win = 0, lose = 0;
        for (Round r : rounds) {
            if (r.getResult().equals("WIN")) {
                win++;
            }
            if (r.getResult().equals("LOSE")) {
                lose++;
            }
        }
        game.setWin(win);
        game.setLose(lose);
        return game;
    }

    public boolean isGameEnd(Game game) {
        return game.getWin() == game.getScoreLimit() || game.getLose() == game.getScoreLimit();
    }

    public Game getGameRes(Game game) {
        if (game.getWin() == game.getScoreLimit()) {
            game.setResult("You win the game.");
        } else {
            game.setResult("You lose the game.");
        }
        return game;
    }
}


