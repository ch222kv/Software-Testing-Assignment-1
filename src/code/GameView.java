package code;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class GameView {
    private PrintStream out;
    private BufferedReader in;

    public GameView(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    public void displayStartMessage() {
        out.println("Welcome to the 21 sticks game!");
    }

    public String getInput() throws IOException {
        return this.in.readLine();
    }

    public void displayQuitMessage() {
        out.println("You are now quitting the game. Have a good day!");
    }

    public int getStickInput() throws NumberFormatException, IOException, NumberIsOutsideRangeException {
        out.print("Please write the number of sticks to take, between 1 and 3: ");
        String input = in.readLine();
        int parsedInt = Integer.parseInt(input);
        if (parsedInt > 3) {
            throw new NumberIsOutsideRangeException();
        } else if (parsedInt <= 0) {
            throw new NumberIsOutsideRangeException();
        }
        return parsedInt;
    }

    public void displaySticksLeft(int sticks){

    }

    public void displayGameInstructions() {
        out.println("The game is called 21 sticks. Your goal is to not take the last stick. You take a number of sticks, between 1 and 3, and the other player does the same. The player tha takes the last one loses.");
    }

    public void displayStartInstructions() {
        out.print("To begin the game write 'y', and to quit write 'Q': ");
    }
}
