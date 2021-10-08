import clent.RpsGameClent;
import model.Game;
import sevice.GameService;
import util.RandomMove;
import util.UserInput;

public class App {

    public static void main(String [] arg){
        //rename class to GameClient?
        RpsGameClent rpsGameClent = new RpsGameClent(new UserInput(), new GameService(new RandomMove()));

        Game game = rpsGameClent.createGame();

        while (!rpsGameClent.isGameEnd(game)){//rename to checkIsGameEnd
            rpsGameClent.makeMove(game);
        }

    }
}
