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
		sut.beginGame();
	}
	
	@Test
	public void shouldDisplayStartMessage(){
		verify(view).displayStartMessage();
	}
	@Test
	public void shouldAskForInput(){
		verify(view).getInput();
	}
	@Test
	public void shouldQuitOnQ(){
		when(view.getInput()).thenReturn('Q');
		verify(view).displayQuitMessage();
	}
}
