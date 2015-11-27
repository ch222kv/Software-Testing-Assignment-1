package code;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameView {
	private PrintStream out;
	private BufferedReader in;
	public GameView(PrintStream out, BufferedReader in){
		this.out = out;
		this.in = in;
	}

	public void displayStartMessage() {
		out.println("Welcome to the 21 sticks game!");
	}

	public String getInput() {
		return "y";
	}
	public void displayQuitMessage(){
		out.println("You are now quitting the game. Have a good day!");
	}

	public int getStickInput() throws NumberFormatException, IOException, NumberIsOutsideRangeException {
		String input = in.readLine();
		if(Integer.parseInt(input) > 3){
			throw new NumberIsOutsideRangeException();
		} else if (input.equals("0")){
			throw new NumberIsOutsideRangeException();
		}
		return Integer.parseInt(input);
	}

}
