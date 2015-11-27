package code;

import java.io.IOException;

public class GameHandler {
	private GameView view;
	private Game game;
	
	public GameHandler(GameView view, Game game){
		this.view = view;
		this.game = game;
	}

	public void beginGame() throws GameHasEndedException, GameHasNotBegunException, IOException {
		view.displayStartMessage();
		view.displayStartInstructions();

		if(view.getInput().equals("y")){
			beginLoop();
		}
		view.displayQuitMessage();
	}
	public void beginLoop() throws GameHasEndedException, GameHasNotBegunException, IOException {
		String input = "";
		int stickInput = 0;

		while(true){
			view.displaySticksLeft(game.getSticksLeft());
			try{
				stickInput = view.getStickInput();
			} catch(NumberFormatException e){
				continue;
			} catch (NumberIsOutsideRangeException e) {
				continue;
			}
			game.takeSticks(stickInput);
		}
	}
}
