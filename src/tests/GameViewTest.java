package tests;
import code.GameView;
import code.InvalidInputException;
import code.NumberIsOutsideRangeException;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by chris on 2015-11-25.
 */
public class GameViewTest {
    private GameView sut;
    private PrintStream out;
    private BufferedReader in;

    @Before
    public void setUp(){
        in = mock(BufferedReader.class);
        out = mock(System.out.getClass());
        sut = new GameView(out, in);
    }
    @Test
    public void testReadInputReturnY() throws IOException {
        when(in.readLine()).thenReturn("y");
        assertEquals("y",sut.getInput());
    }
    @Test
    public void testDisplayStartMessage(){
        sut.displayStartMessage();
        verify(out).println("Welcome to the 21 sticks game!");
    }

    @Test
    public void testDisplayQuitMessage(){
        sut.displayQuitMessage();
        verify(out).println("You are now quitting the game. Have a good day!");
    }

    @Test
    public void testGetSticksInputWith2() throws IOException, NumberFormatException, NumberIsOutsideRangeException {
        when(in.readLine()).thenReturn("2");

        assertEquals(2, sut.getStickInput());
    }

    @Test(expected = NumberFormatException.class)
    public void testGetSticksInputWithInputThatIsNotANumberShouldThrowNumberFormatException() throws IOException, NumberIsOutsideRangeException {
        when(in.readLine()).thenReturn("x");
        sut.getStickInput();
    }
    @Test(expected = NumberIsOutsideRangeException.class)
    public void testGetSticksInputWithInputBiggerThan3() throws IOException, NumberIsOutsideRangeException {
        when(in.readLine()).thenReturn("4");
        sut.getStickInput();
    }
    @Test(expected = NumberIsOutsideRangeException.class)
    public void testGetSticksInputWithInputBeing0() throws IOException, NumberIsOutsideRangeException {
        when(in.readLine()).thenReturn("0");
        sut.getStickInput();
    }
    @Test(expected = NumberIsOutsideRangeException.class)
    public void testGetSticksInputWithInputSmallerThan0() throws IOException, NumberIsOutsideRangeException {
        when(in.readLine()).thenReturn("-1");
        sut.getStickInput();
    }
    @Test
    public void testDisplayGameInstructions(){
        sut.displayGameInstructions();
        verify(out).println("The game is called 21 sticks. Your goal is to not take the last stick. You take a number of sticks, between 1 and 3, and the other player does the same. The player tha takes the last one loses.");
    }
    @Test
    public void testGetSticksPrintsInstructions() throws IOException, NumberIsOutsideRangeException {
        try{
            sut.getStickInput();
        } catch(NumberFormatException e){
        }

        verify(out).print("Please write the number of sticks to take, between 1 and 3: ");
    }

    @Test
    public void testDispayStartInstructions(){
        sut.displayStartInstructions();
        verify(out).print("To begin the game write 'y', and to quit write 'Q': ");
    }
    @Test
    public void testDisplaySticksLeft(){
        sut.displaySticksLeft(5);
        verify(out).println("There are 5 sticks left.");
    }
}