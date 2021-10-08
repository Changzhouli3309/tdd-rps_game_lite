package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
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

}
