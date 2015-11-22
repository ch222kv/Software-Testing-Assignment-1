package code;

public class GameHandler {
	private GameView view;
	private Game game;
	
	public GameHandler(GameView view, Game game){
		this.view = view;
		this.game = game;
	}

	public void beginGame() {
		view.displayStartMessage();
		if(view.getInput() == 'y'){
			beginLoop();
		}
		view.displayQuitMessage();
	}
	public void beginLoop(){
		do{
			
		}while(view.getInput() != 'Q');
	}
}
