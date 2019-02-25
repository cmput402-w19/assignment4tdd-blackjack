package blackjack;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	public void testGiveOne(){
		Game game = new Game();
		assertEquals(game.giveOne(), 0);
	}
}
