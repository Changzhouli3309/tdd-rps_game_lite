package model;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private int scoreLimit, win, lose;
    private String result;
    private List<Round> rounds;

    public Game(int scoreLimit) {
        this.scoreLimit = scoreLimit;
        this.win = 0;
        this.lose = 0;
        this.result = "";
        this.rounds = new ArrayList<>();
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "model.Game{" +
                "scoreLimit=" + scoreLimit +
                ", win=" + win +
                ", lose=" + lose +
                ", result='" + result + '\'' +
                ", rounds=" + rounds +
                '}';
    }
}
