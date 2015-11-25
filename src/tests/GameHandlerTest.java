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
    public void shouldNotQuitFirstTimegetInputIsCalled() throws GameHasEndedException, GameHasNotBegunException, IOException {
        when(view.getInput()).thenReturn("y").thenReturn("x").thenReturn("Q");

        sut.beginGame();
        verify(view, times(3)).getInput();
    }

    @Test
    public void shouldAskForStickCount() throws GameHasEndedException, GameHasNotBegunException, InvalidInputException, IOException {
        when(view.getInput()).thenReturn("y").thenReturn("Q");
        sut.beginGame();
        verify(view).getStickInput();
    }

    @Test
    public void shouldResetWhenInputIsR() throws GameHasNotBegunException, GameHasEndedException, IOException {
        when(view.getInput()).thenReturn("y").thenReturn("R").thenReturn("Q");
        when(game.takeSticks(anyInt())).thenThrow(GameHasEndedException.class);

        sut.beginGame();
        try {
            game.takeSticks(0);
        } catch (GameHasEndedException e) {
            verify(game).resetGame();
        }
    }

    @Test
    public void shouldThrowGameHasEnded() throws GameHasNotBegunException, IOException {
        game = new Game();
        sut = new GameHandler(view, game);

        when(view.getInput()).thenReturn("y").thenReturn("9").thenReturn("9").thenReturn("2").thenReturn("Q");

        try {
            sut.beginGame();
            fail("Game should have ended");
        } catch (GameHasEndedException e) {

        }
    }
}
