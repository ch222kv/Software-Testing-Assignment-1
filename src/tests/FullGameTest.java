package tests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import code.*;

public class FullGameTest {
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
	public void shouldDisplayStartMessage(){
		sut.beginGame();
		verify(view).displayStartMessage();
	}
	@Test
	public void shouldAskForInput(){
		sut.beginGame();
		verify(view, atLeast(1)).getInput(); //Ignore multiple if there are
	}
	@Test
	public void shouldQuitOnQ(){
		when(view.getInput()).thenReturn('Q');
		sut.beginGame();
		verify(view).displayQuitMessage();
	}
	@Test
	public void shouldNotQuitFirstTimegetInputIsCalled(){
		when(view.getInput()).thenReturn('y').thenReturn('x').thenReturn('Q');
		
		sut.beginGame();
		verify(view, times(3)).getInput();
	}
	@Test
	public void shouldAskForStickCount(){
		when(view.getInput()).thenReturn('y').thenReturn('Q');
		sut.beginGame();
		verify(view).getStickInput();
	}
	@Test
	public void shouldResetWhenInputIsR() throws GameHasNotBegunException, GameHasEndedException{
		when(view.getInput()).thenReturn('y').thenReturn('R').thenReturn('Q');
		when(game.takeSticks(anyInt())).thenThrow(GameHasEndedException.class);
		
		sut.beginGame();
		try {
			game.takeSticks(0);
		} catch (GameHasEndedException e) {
			verify(game).resetGame();
		}
	}
	@Test
	public void shouldThrowGameHasEnded(){
		when(view.getInput()).thenReturn('y').thenReturn('9').thenReturn('9').thenReturn('2');
		try{
			sut.beginGame();
			fail("Game should have ended");
		} catch(GameHasEndedException e){
			
		}
	}
}
