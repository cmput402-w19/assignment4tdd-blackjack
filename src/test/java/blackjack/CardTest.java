package blackjack;

import junit.framework.TestCase;

//spades, hearts, clubs, diamonds
public class CardTest extends TestCase {
	
	public void testGetScore(){
		Card card = new Card("king", "spade");
		assertEquals(card.getScore(), 10);
		
		card = new Card("ace", "hearts");
		assertEquals(card.getScore(), 11);
		
		card = new Card("1", "clubs");
		assertEquals(card.getScore(), 1);
		
		card = new Card("10", "diamonds");
		assertEquals(card.getScore(), 10);
	}

}
