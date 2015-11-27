package tests;

import code.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameHandlerTest {
    private GameView view;
    private Game game;
    private GameHandler sut;

    @Before
    public void setUp() {
        view = mock(GameView.class);
        game = mock(Game.class);
        sut = new GameHandler(view, game);
    }

    @Test
    public void shouldDisplayStartMessage() throws GameHasEndedException, GameHasNotBegunException, IOException {
        when(view.getInput()).thenReturn("Q");
        sut.beginGame();
        verify(view).displayStartMessage();
        verify(view).displayStartInstructions();
    }

    @Test
    public void shouldAskForInput() throws GameHasEndedException, GameHasNotBegunException, IOException {
        when(view.getInput()).thenReturn("Q");
        sut.beginGame();
        verify(view, atLeast(1)).getInput(); //Ignore multiple if there are
    }

    @Test
    public void shouldQuitOnQ() throws GameHasEndedException, GameHasNotBegunException, IOException {
        when(view.getInput()).thenReturn("Q");
        sut.beginGame();
        verify(view).displayQuitMessage();
    }

    @Test
    public void shouldAskForStickCount() throws GameHasEndedException, GameHasNotBegunException, InvalidInputException, IOException, NumberIsOutsideRangeException {
        when(view.getInput()).thenReturn("y").thenReturn("Q");
        when(view.getStickInput()).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(2);
        when(game.takeSticks(anyInt())).thenCallRealMethod();
        when(game.getSticksLeft()).thenReturn(17).thenReturn(14).thenReturn(11).thenReturn(8).thenReturn(5).thenReturn(2).thenThrow(GameHasEndedException.class);

        try{
            sut.beginGame();
        } catch(GameHasEndedException e){}
        verify(view, times(6)).getStickInput();
    }

    @Test
    public void shouldThrowGameHasEnded() throws GameHasNotBegunException, IOException, NumberIsOutsideRangeException {
        game = new Game();
        sut = new GameHandler(view, game);

        when(view.getInput()).thenReturn("y").thenReturn("Q");
        when(view.getStickInput()).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(2);

        try {
            sut.beginGame();
            fail("Game should have ended");
        } catch (GameHasEndedException e) {

        }
    }
    @Test
    public void testPrintOutSticksLeft() throws GameHasNotBegunException, IOException, NumberIsOutsideRangeException, GameHasEndedException {
        when(view.getInput()).thenReturn("y").thenReturn("Q");
        when(view.getStickInput()).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(3).thenReturn(2);
        when(game.takeSticks(anyInt())).thenCallRealMethod();
        when(game.getSticksLeft()).thenReturn(17).thenReturn(14).thenReturn(11).thenReturn(8).thenReturn(5).thenReturn(2).thenThrow(GameHasEndedException.class);
        try{
            sut.beginGame();
        } catch(GameHasEndedException e){}

        verify(view, times(6)).displaySticksLeft(anyInt());
    }
}
