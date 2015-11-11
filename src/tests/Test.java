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
		assertFalse(game.takeSticks(20));
	}

}
