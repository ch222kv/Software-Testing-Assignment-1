package tests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;

import code.*;

public class GameViewTest {
	private GameView sut;
	
	@Before
	public void setUp() {
		sut = mock(GameView.class);
	}
	
	@org.junit.Test
	public void testDisplayStartMessage(){
		sut.beginGame();
		
		verify(sut).displayStartMessage();
	}
}
