package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	Hand hand2;
	
	public void setUp(){
		Card card2 = new Card("king","hearts");
		Card card3 = new Card("queen","hearts");
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.add(card2);
		cards2.add(card3);
		Hand hand2 = new Hand(cards2);
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
		Player player = new Player(null);
		
	}
	
	public void testGetTies(){
		Player player = new Player(null);
		
	}
	
	public void testSetHand(){
		Player player = new Player(null);
		
	}
	
	public void testSetWins(){
		Player player = new Player(null);
		
	}
	
	public void testSetLosses(){
		Player player = new Player(null);
		
	}
	
	public void testSetTies(){
		Player player = new Player(null);
		
	}
	
}
