package tests;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import code.*;

public class GameTest {
	private Game sut = null;
	
	@org.junit.Before
	public void setUp(){
		sut = new Game();
		sut.beginGame();
	}
	@org.junit.Test
	public void testGetSticks() throws GameHasNotBegunException, GameHasEndedException {
		assertEquals(sut.getSticksLeft(), 20);
		assertTrue(sut.takeSticks(1));
		assertEquals(sut.getSticksLeft(), 19);
		
		assertFalse(sut.takeSticks(sut.getSticksLeft() + 1));
		//Can't take more sticks than there are left
		
		for(int i = 20; i < 100; i++){
			assertFalse(sut.takeSticks(i));
		}
	}
	@org.junit.Test
	public void testGameHasEnded() throws GameHasNotBegunException{
		assertFalse(sut.hasEnded());
		try{
			sut.takeSticks(sut.getSticksLeft());
			fail("Should throw GameHasEndedException");
		} catch(GameHasEndedException e){}
		assertTrue(sut.hasEnded());
	}
	@org.junit.Test
	public void testBeginGame() throws GameHasNotBegunException{
		Game sut = new Game();
		sut.beginGame();
		assertFalse(sut.hasEnded());
		
		try{
			sut.takeSticks(sut.getSticksLeft());
		} catch(GameHasEndedException e){}
		
		
		assertTrue(sut.hasEnded());
	}
	@org.junit.Test
	public void testGameBeginMessage(){
		PrintStream out = spy(System.out);
		Game sut = new Game(out);
		
		sut.beginGame();
		
		verify(out).println("The game has begun!");
	}
	@org.junit.Test
	public void testNotTakeSticksBeforeGameBegin() throws GameHasEndedException{
		Game sut = new Game();
		try{
			sut.takeSticks(4);
			fail("Exception should be thrown");
		} catch(GameHasNotBegunException e){
			
		}
		sut.beginGame();
		try{
			sut.takeSticks(4);
		} catch(GameHasNotBegunException e){
			fail("Exception should not be thrown");
		}
	}
	@org.junit.Test
	public void testAllowAnyCountOfSticks(){
		Game sut = new Game(200);
		
		Game sut_2 = new Game(2);
		
		int stickCount = sut.getSticksLeft();
		sut.beginGame();
		assertEquals(stickCount, sut.getSticksLeft());
		assertEquals(sut_2.getSticksLeft(), 2);
	}
	@org.junit.Test
	public void testSticksAfterResetSameAsBefore(){
		Game sut = new Game(200);
		int stickCount = sut.getSticksLeft();
		sut.beginGame();
		assertEquals(stickCount, sut.getSticksLeft());
	}
	@org.junit.Test(expected=GameHasEndedException.class)
	public void testTakeSticksThrowsGameHasEndedExceptionOnGameEnd() throws GameHasNotBegunException, GameHasEndedException{
		Game sut = new Game();
		sut.beginGame();
		sut.takeSticks(sut.getSticksLeft());
	}
}
