import controller.RpsGame;
import model.Game;
import sevice.GameProgress;
import util.RandomMove;
import util.UserInput;

public class App {

    public static void main(String [] arg){

        RpsGame rpsGame = new RpsGame(new UserInput(),
                new GameProgress(new RandomMove()));

        Game game = rpsGame.createGame();

        while (!rpsGame.getResult(game)){
            rpsGame.makeMove(game);
        }

    }
}
