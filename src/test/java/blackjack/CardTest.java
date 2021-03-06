package blackjack;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import junit.framework.TestCase;

import java.util.ArrayList;


//spades, hearts, clubs, diamonds
public class CardTest extends TestCase {
	
	public void testEquals(){
		Card card1 = new Card(Suit.SPADE, Value.KING);
		Card card2 = new Card(Suit.SPADE, Value.KING);
		assertEquals(card1, card2);
		
		Card card3 = new Card(Suit.CLUB, Value.EIGHT);
		Card card4 = new Card(Suit.SPADE, Value.KING);
		
		assertNotEquals(card3,card4);
		
		Card card5 = new Card(Suit.CLUB, Value.EIGHT);
		assertEquals(card5.getSuit(), Suit.CLUB);
		assertNotEquals(card5.getSuit(), Suit.DIAMOND);
		assertEquals(card5.getValue(), Value.EIGHT);
		assertNotEquals(card5.getValue(), Value.NINE);
		
		Card card6 = new Card(Suit.CLUB, Value.TEN);
		Card card7 = new Card(Suit.CLUB, Value.ACE);
		
		assertNotEquals(card6, card7);
		
		Card aCard = new Card(Suit.CLUB, Value.EIGHT);
		assertTrue(aCard.equals(aCard));
		assertFalse(aCard.equals(1));
		
	}

	public void testEqualsNotInstance(){
		Card card1 = new Card(Suit.SPADE, Value.KING);
		ArrayList lis = new ArrayList<Integer>();
		assertNotEquals(card1, lis);
		
	}
	
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
