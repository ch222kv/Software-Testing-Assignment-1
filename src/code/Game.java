package code;

import java.io.PrintStream;

import tests.GameHasNotBegunException;

public class Game {
	private int sticks = 20;
	private PrintStream outStream = null;
	private boolean gameBegun = false;
	
	public Game(){
		this(System.out);
	}
	public Game(PrintStream outStream){
		this.outStream = outStream;
	}

	public int getSticksLeft() {
		// TODO Auto-generated method stub
		return sticks;
	}
	
	public boolean takeSticks(int i) throws GameHasNotBegunException {
		if(!gameBegun){
			throw new GameHasNotBegunException();
		}
		if(i > sticks){
			return false;
		}
		sticks -= i;
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasEnded() {
		if(sticks == 0){
			return true;
		}
		return false;
	}

	public void beginGame() {
		gameBegun = true;
		sticks = 20;
		this.outStream.println("The game has begun!");
	}

}
