package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	Hand hand2;
	Hand hand3;
	
	public void setUp(){
		Card card2 = new Card(Suit.HEART, Value.KING);
		Card card3 = new Card(Suit.HEART, Value.QUEEN);
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		hand2 = new Hand(cards2);
		
		Card card4 = new Card(Suit.HEART,Value.ACE);
		Card card5 = new Card(Suit.HEART,Value.THREE);
		Card card6 = new Card(Suit.HEART,Value.TEN);
		ArrayList<Card> cards3 = new ArrayList<Card>();
		cards3.add(card4);
		cards3.add(card5);
		cards3.add(card6);
		hand3 = new Hand(cards3);
		
	}
	
	public void testGetHand(){
		Player player = new Player(hand2);
		
		assertEquals(player.getHand(), hand2);
		
	}
	
	public void testGetWins(){
		Player player = new Player(hand2);
		
		assertEquals(player.getWins(), 0);
		
	}
	
	public void testGetLosses(){
		Player player = new Player(hand2);
		
		assertEquals(player.getLosses(), 0);
		
	}
	
	public void testGetTies(){
		Player player = new Player(hand2);
		
		assertEquals(player.getTies(), 0);
	}
	
	public void testSetHand(){
		Player player = new Player(hand2);
		player.setHand(hand3);
		assertEquals(player.getHand(), hand3);
			
	}
	
	public void testSetWins(){
		Player player = new Player(hand2);
		player.setWins(10);
		assertEquals(player.getWins(), 10);
		
	}
	
	public void testSetLosses(){
		Player player = new Player(hand2);
		player.setLosses(1);
		assertEquals(player.getLosses(),1);
		
	}
	
	public void testSetTies(){
		Player player = new Player(hand2);
		player.setTies(999999);
		assertEquals(player.getTies(), 999999);
	}
	
}
