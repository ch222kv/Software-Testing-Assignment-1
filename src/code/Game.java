package code;

import java.io.PrintStream;

import tests.GameHasNotBegunException;

public class Game {
	private int currentSticks;
	private int maxSticks;
	private PrintStream outStream = null;
	private boolean gameBegun = false;
	
	public Game(){
		this(System.out);
	}
	public Game(PrintStream outStream){
		this(20, outStream);
	}
	public Game(int stickCount){
		this(stickCount, System.out);
	}
	public Game(int stickCount, PrintStream outStream){
		currentSticks = stickCount;
		maxSticks = stickCount;
		this.outStream = outStream;
	}

	public int getSticksLeft() {
		// TODO Auto-generated method stub
		return currentSticks;
	}
	
	public boolean takeSticks(int i) throws GameHasNotBegunException, GameHasEndedException {
		if(!gameBegun){
			throw new GameHasNotBegunException();
		}
		if(i > currentSticks){
			return false;
		}
		currentSticks -= i;
		if(currentSticks == 0){
			throw new GameHasEndedException();
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasEnded() {
		if(currentSticks == 0){
			return true;
		}
		return false;
	}

	public void beginGame() {
		gameBegun = true;
		currentSticks = maxSticks;
		this.outStream.println("The game has begun!");
	}

}
