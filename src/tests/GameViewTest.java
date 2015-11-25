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
    @Test
    public void testGetInputString() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        GameView sut = new GameView(System.out, bufferedReader);
        when(bufferedReader.readLine()).thenReturn("first line").thenReturn("second line");

        assertEquals("y", sut.getInput());
    }
}
