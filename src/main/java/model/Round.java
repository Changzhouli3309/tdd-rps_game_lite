package model;

public class Round {
    private String playerMove, aiMove, result;

    public Round(String playerMove, String aiMove, String result) {
        this.playerMove = playerMove;
        this.aiMove = aiMove;
        this.result = result;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getAiMove() {
        return aiMove;
    }

    public void setAiMove(String aiMove) {
        this.aiMove = aiMove;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "model.Round{" +
                "playerMove='" + playerMove + '\'' +
                ", aiMove='" + aiMove + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
