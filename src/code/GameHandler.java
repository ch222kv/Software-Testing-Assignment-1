package code;

public class GameHandler {
	private GameView view;
	private Game game;
	
	public GameHandler(GameView view, Game game){
		this.view = view;
		this.game = game;
	}

	public void beginGame() throws GameHasEndedException, GameHasNotBegunException {
		view.displayStartMessage();
		
		if(view.getInput().equals("y")){
			beginLoop();
		}
		view.displayQuitMessage();
	}
	public void beginLoop() throws GameHasEndedException, GameHasNotBegunException{
		String input;
		do{
			view.getStickInput();
			input = view.getInput();
			if(input.equals("R")){
				game.resetGame();
			} else if(Character.isDigit(input)){
				try {
					game.takeSticks(Integer.parseInt(Character.toString(input)));
				} catch (NumberFormatException e) {
				}
			}
		}while(!input.equals("Q"));
	}
}
