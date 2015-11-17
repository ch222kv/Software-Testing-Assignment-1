package tests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import code.*;

public class Test {
	private Game game = null;
	
	@org.junit.Before
	public void setUp(){
		this.game = new Game();
		this.game.beginGame();
	}
	@org.junit.Test
	public void testGetSticks() throws GameHasNotBegunException {
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
	public void testGameHasEnded() throws GameHasNotBegunException{
		assertFalse(this.game.hasEnded());
		this.game.takeSticks(game.getSticksLeft());
		assertTrue(this.game.hasEnded());
	}
	@org.junit.Test
	public void testBeginGame() throws GameHasNotBegunException{
		Game game = new Game();
		game.beginGame();
		assertFalse(game.hasEnded());
		
		game.takeSticks(this.game.getSticksLeft());
		
		assertTrue(game.hasEnded());
	}
	@org.junit.Test
	public void testGameBeginMessage(){
		PrintStream out = spy(System.out);
		Game game = new Game(out);
		
		game.beginGame();
		
		verify(out).println("The game has begun!");
	}
	@org.junit.Test
	public void testNotTakeSticksBeforeGameBegin(){
		Game game = new Game();
		try{
			game.takeSticks(4);
			fail("Exception should be thrown");
		} catch(GameHasNotBegunException e){
			
		}
		game.beginGame();
		try{
			game.takeSticks(4);
		} catch(GameHasNotBegunException e){
			fail("Exception should not be thrown");
		}
	}
}
