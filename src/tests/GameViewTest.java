package tests;
import code.GameView;
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
    public void testGetInputString() throws IOException {
        when(in.readLine()).thenReturn("first line").thenReturn("second line");

        assertEquals("y", sut.getInput());
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
    public void testGetSticksInputWith2() throws IOException{
        when(in.readLine()).thenReturn("2");

        assertEquals(2, sut.getStickInput());
    }

    @Test
    public void testGetSticksInputWithInputThatIsNotANumber() throws IOException{
        when(in.readLine()).thenReturn("x");
        try{
            sut.getStickInput();
            fail("getStickInput should throw InvalidInputException on anything not a valid number");
        } catch(InvalidInputException e){

        }
    }
}
