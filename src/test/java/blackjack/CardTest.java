package blackjack;

import junit.framework.TestCase;

//spades, hearts, clubs, diamonds
public class CardTest extends TestCase {
	
	public void testGetScore(){
		Card card = Card('k', 's');
		assertEquals(card.getScore(), 10);
	}

}
