package tests;

import static org.junit.Assert.*;

import code.*;

public class Test {

	@org.junit.Test
	public void test() {
		Game game = new Game();
		
		assertEquals(game.getSticksLeft(), 20);
		assertTrue(game.takeSticks(1));
		assertEquals(game.getSticksLeft(), 19);
		
		//Can't take more sticks than there are left
		assertFalse(game.takeSticks(20));
		for(int i = 20; i < 100; i++){
			assertFalse(game.takeSticks(i));
		}
		assertFalse(game.hasEnded());
		game.takeSticks(game.getSticksLeft());
		assertTrue(game.hasEnded());
	}

}
