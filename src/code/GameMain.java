package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chris on 2015-11-27.
 */
public class GameMain {
    public static void main(String[] args) throws GameHasNotBegunException, GameHasEndedException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        GameView view = new GameView(System.out, in);
        GameHandler gh = new GameHandler(view, new Game());
        gh.beginGame();
    }
}
