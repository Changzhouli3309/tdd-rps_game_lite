import client.RpsGameClient;
import model.Game;
import sevice.GameService;
import util.RandomMove;
import util.UserInput;

public class App {

    public static void main(String [] arg){

        RpsGameClient rpsGameClient = new RpsGameClient(new UserInput(), new GameService(new RandomMove()));

        Game game = rpsGameClient.createGame();

        while (!rpsGameClient.isGameEnd(game)){
            rpsGameClient.makeMove(game);
        }

    }
}
