package blackjack;

import junit.framework.TestCase;
// import org.mockito.Mockito.*;

public class GameTest extends TestCase {
	Game game;
	
	public void setUp(){
		game = new Game();
	}
	
	public void testSetPlayer1(){
		// use mocking here to avoid messy creation of player obj
		
	}
	
	public void testSetPlayer2(){
		// use mocking here to avoid messy creation of player obj
	}

	public void testSetDeck(){
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
		
		game.setDeck(deck);
		
		assertEquals(deck, game.getDeck());
		
	}
	
	public void testSetWinner(){
		// use mocking here to avoid messy creation of player obj
	}
	
	public void testGetPlayer1(){
		Player newPlayer = new Player(null);
		game.setPlayer1(newPlayer);
		
		assertEquals(newPlayer, game.getPlayer1());
		
	}
	
	public void testGetPlayer2(){
		Player newPlayer = new Player(null);
		game.setPlayer2(newPlayer);
		
		assertEquals(newPlayer, game.getPlayer2());
	}

	public void testGetDeck(){
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
		
		game.setDeck(deck);
		
		assertEquals(deck, game.getDeck());
	}
	
}

