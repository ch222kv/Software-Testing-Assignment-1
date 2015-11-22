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
}
