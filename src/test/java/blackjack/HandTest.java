package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	Card card1;
	Card card4;
	Card card5;
	Card card6;
	
	ArrayList<Card> cards1;
	ArrayList<Card> cards3;
	ArrayList<Card> cards4;
	
	Hand hand1;
	Hand hand2;
	Hand hand3;
	Hand hand4 =null;
	
	Hand hand5;
	
	public void setUp(){
		card1 = new Card(Suit.SPADE, Value.KING);
		cards1 = new ArrayList<Card>();
		cards1.add(card1);
		hand1 = new Hand(cards1);
		hand2 = new Hand(cards1);
		
		card4 = new Card(Suit.HEART, Value.EIGHT);
		card5 = new Card(Suit.HEART, Value.TWO);
		card6 = new Card(Suit.HEART, Value.TEN);
		cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		hand3 = new Hand(cards3);
		
		cards4 = new ArrayList<Card>();
		for(Suit suit: Suit.values()) {
			for(Value value: Value.values()) {
				// Add cards to a list
				cards4.add(new Card(suit,value));
			}
		}
		hand5 = new Hand(cards4);	
		
			
	}
	
	public void testEquals(){
		
		assertEquals(hand1, hand2);
		assertFalse(hand1.equals(hand3));
		
		assertFalse(hand1.equals(1));
		
	}
	
	public void testGetScore(){
		assertEquals(hand1.getScore(), 10);
		assertEquals(hand3.getScore(), 20);
		assertEquals(hand5.getScore(), 340);
	}
	
	public void testGetCount(){
		
		assertEquals(hand1.getCount(), 1);
		
		assertEquals(hand3.getCount(), 3);
	}
	
	public void	testGetCards(){
		
		assertEquals(hand1.getCards(), cards1);
		
		assertEquals(hand3.getCards(), cards3);
	}
	
	public void testAddCard(){
		
		Card card = new Card(Suit.SPADE, Value.KING);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card4);
		
		hand1.addCard(card4);
		assertEquals(cards, hand1.getCards());
		
		
		
	}

	public void testToString() {		
		hand1.addCard(new Card(Suit.SPADE, Value.KING));
		hand1.addCard(new Card(Suit.SPADE, Value.KING));

		String s = hand1.toString();

		assertEquals("SPADE:KING, SPADE:KING, SPADE:KING, ", s);
	}

}
