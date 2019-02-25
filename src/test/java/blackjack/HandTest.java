package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	public void testGetScore(){
		Card card1 = new Card(Suit.HEART, Value.KING);
		ArrayList<Card> cards1 = new ArrayList<Card>();
		cards1.add(card1);
		Hand hand1 = new Hand(cards1);
		assertEquals(hand1.getScore(), 10);
		
		Card card2 = new Card(Suit.HEART, Value.KING);
		Card card3 = new Card(Suit.HEART, Value.QUEEN);
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		Hand hand2 = new Hand(cards2);
		assertEquals(hand2.getScore(), 20);
		
		Card card4 = new Card(Suit.HEART, Value.ACE);
		Card card5 = new Card(Suit.HEART, Value.TWO);
		Card card6 = new Card(Suit.HEART, Value.NINE);
		Card card7 = new Card(Suit.HEART, Value.TEN);
		
		ArrayList<Card> cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		cards3.add(card7);
		Hand hand3 = new Hand(cards3);
		
		assertEquals(hand3.getScore(), 22);
		
	}
	
	public void testGetCount(){
		Card card1 = new Card(Suit.HEART, Value.KING);
		ArrayList<Card> cards1 = new ArrayList<Card>();
		cards1.add(card1);
		Hand hand1 = new Hand(cards1);
		
		assertEquals(hand1.getCount(), 1);
		
		Card card2 = new Card(Suit.HEART, Value.KING);
		Card card3 = new Card(Suit.HEART, Value.QUEEN);
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		Hand hand2 = new Hand(cards2);
		
		assertEquals(hand2.getCount(), 2);
		
		Card card4 = new Card(Suit.HEART, Value.ACE);
		Card card5 = new Card(Suit.HEART, Value.TWO);
		Card card6 = new Card(Suit.HEART, Value.NINE);
		Card card7 = new Card(Suit.HEART, Value.TEN);
		ArrayList<Card> cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		cards3.add(card7);
		Hand hand3 = new Hand(cards3);
		
		assertEquals(hand3.getCount(), 4);
	}
	
	public void	testGetCards(){
		Card card1 = new Card(Suit.HEART, Value.KING);
		ArrayList<Card> cards1 = new ArrayList<Card>();
		cards1.add(card1);
		Hand hand1 = new Hand(cards1);
		
		assertEquals(hand1.getCards(), cards1);
		
		Card card2 = new Card(Suit.HEART, Value.KING);
		Card card3 = new Card(Suit.HEART, Value.QUEEN);
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		Hand hand2 = new Hand(cards2);
		
		assertEquals(hand2.getCards(), cards2);
		
		Card card4 = new Card(Suit.HEART, Value.ACE);
		Card card5 = new Card(Suit.HEART, Value.TWO);
		Card card6 = new Card(Suit.HEART, Value.NINE);
		Card card7 = new Card(Suit.HEART, Value.TEN);
		ArrayList<Card> cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		cards3.add(card7);
		Hand hand3 = new Hand(cards3);
		
		assertEquals(hand3.getCards(), cards3);
	}

}
