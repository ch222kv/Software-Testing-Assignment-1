package tests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import code.*;

public class Test {
	private Game game = null;
	
	@org.junit.Before
	public void setUp(){
		this.game = new Game();
	}
	@org.junit.Test
	public void test() {
		
	}
	@org.junit.Test
	public void testGetSticks() {
		assertEquals(this.game.getSticksLeft(), 20);
		assertTrue(this.game.takeSticks(1));
		assertEquals(this.game.getSticksLeft(), 19);
		
		assertFalse(this.game.takeSticks(this.game.getSticksLeft() + 1));
		//Can't take more sticks than there are left
		
		for(int i = 20; i < 100; i++){
			assertFalse(this.game.takeSticks(i));
		}
	}
	@org.junit.Test
	public void testGameHasEnded(){
		assertFalse(this.game.hasEnded());
		this.game.takeSticks(game.getSticksLeft());
		assertTrue(this.game.hasEnded());
	}
	@org.junit.Test
	public void testBeginGame(){
		this.game.takeSticks(this.game.getSticksLeft());
		
		assertTrue(this.game.hasEnded());
		
		this.game.beginGame();
		
		assertFalse(this.game.hasEnded());
	}

}
