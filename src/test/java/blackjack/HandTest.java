package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	public void testGetScore(){
		Card card1 = new Card("king","hearts");
		ArrayList<Card> cards1 = new ArrayList<Card>();
		cards1.add(card1);
		Hand hand1 = new Hand(cards1);
		
		assertEquals(hand1.getScore(), 10);
		
		Card card2 = new Card("king","hearts");
		Card card3 = new Card("queen","hearts");
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		Hand hand2 = new Hand(cards2);
		
		assertEquals(hand2.getScore(), 20);
		
		Card card4 = new Card("1","hearts");
		Card card5 = new Card("2","hearts");
		Card card6 = new Card("9","hearts");
		Card card7 = new Card("10","hearts");
		ArrayList<Card> cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		cards3.add(card7);
		Hand hand3 = new Hand(cards3);
		
		assertEquals(hand2.getScore(), 22);
		
	}

}
