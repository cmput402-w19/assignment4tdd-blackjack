package blackjack;

import junit.framework.TestCase;

//spades, hearts, clubs, diamonds
public class CardTest extends TestCase {
	
	public void testGetScore(){
		Card card = new Card(Suit.SPADE, Value.KING);
		assertEquals(Suit.SPADE, card.getSuit());
		assertEquals(Value.KING, card.getValue());
		
		card = new Card(Suit.HEART, Value.QUEEN);
		assertEquals(Suit.HEART, card.getSuit());
		assertEquals(Value.QUEEN, card.getValue());
		
		card = new Card(Suit.CLUB, Value.ACE);
		assertEquals(Suit.CLUB, card.getSuit());
		assertEquals(Value.ACE, card.getValue());

		
		card = new Card(Suit.DIAMOND, Value.TEN);
		assertEquals(Suit.DIAMOND, card.getSuit());
		assertEquals(Value.TEN, card.getValue());

	}

}
