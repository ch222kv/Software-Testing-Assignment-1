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
		do{
			view.displaySticksLeft(game.getSticksLeft());
			try{
				view.getStickInput();
			} catch(NumberFormatException e){
				continue;
			} catch (NumberIsOutsideRangeException e) {
				continue;
			}
			input = view.getInput();
			if(input.equals("R")){
				game.resetGame();
			} else {
				try {
					game.takeSticks(Integer.parseInt(input));
				} catch (NumberFormatException e) {
				}
			}
		}while(!input.equals("Q"));
	}
}
