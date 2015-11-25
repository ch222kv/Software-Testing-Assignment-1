package code;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameView {
	private PrintStream out;
	public GameView(PrintStream out, BufferedReader in){
		this.out = out;
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

	public void getStickInput() {
		// TODO Auto-generated method stub
		
	}

}
