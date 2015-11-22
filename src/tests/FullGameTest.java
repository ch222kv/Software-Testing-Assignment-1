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
	public void displayStartMessage(){
		verify(view).displayStartMessage();
	}
}
