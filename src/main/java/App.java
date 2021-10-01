import controller.RpsGame;
import model.Game;
import sevice.GameProgress;
import util.InputChecker;
import util.RandomMove;
import util.UserInput;

public class App {

    public static void main(String [] arg){

        RpsGame rpsGame = new RpsGame(new UserInput(),
                new GameProgress(new RandomMove()),
                new InputChecker());

        Game game = rpsGame.createGame();

        while (!rpsGame.getResult(game)){
            rpsGame.makeMove(game);
        }

//        Scanner scanner = new Scanner(System.in);
//        GameProgress gp = new GameProgress(new RandomMove());
//        InputChecker ic= new InputChecker();
//
//        System.out.println("Set score limit");
//        String scoreLimit = scanner.nextLine();
//
//        while (!ic.checkInt(scoreLimit)){
//            System.out.println("Wrong input. Try again");
//            scoreLimit = scanner.nextLine();
//        }
//
//        model.Game game = new model.Game(Integer.parseInt(scoreLimit));
//
//        while (gp.isGameEnd(game)){
//            System.out.println("\nyou move:(ROCK,PAPER,SCISSORS)");
//            String playerMove = scanner.nextLine();
//
//            while (!ic.checkMove(playerMove)){
//                System.out.println("Wrong input. Try again");
//                playerMove = scanner.nextLine();
//            }
//
//            String aiMove = gp.getRandomAiMove();
//            String result = gp.getResult(playerMove,aiMove);
//            model.Round round = new model.Round(playerMove,aiMove,result);
//
//            System.out.println(round);
//
//            game.getRounds().add(round);
//            game = gp.updateScore(game);
//
//            System.out.println("win: "+game.getWin()+" lose: "+game.getLose()+" limit: "+game.getScoreLimit());
//        }
//
//        System.out.println();
//
//        game = gp.getResult(game);
//
//        System.out.println(game.getResult());
//        System.out.println("-------log--------");
//        game.getRounds().forEach(System.out::println);

    }
}
