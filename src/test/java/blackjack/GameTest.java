package blackjack;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest extends TestCase {
	Game game;
	Player player1;
	Player player2;
	Deck deck;
	
	@Before
	public void setUp(){
		player1 = mock(Player.class);
		player2 = mock(Player.class);
		deck = mock(Deck.class);

		game = new Game(deck, player1, player2);

		// game = new Game();
	}
	
	@Test
	public void testSetPlayer1(){
		Player p1 = mock(Player.class);

		game.setPlayer1(p1);

		assertSame(p1, game.getPlayer1());
	}
	
	@Test
	public void testSetPlayer2(){
		Player p1 = mock(Player.class);

		game.setPlayer1(p1);

		assertSame(p1, game.getPlayer1());
	}

	@Test
	public void testSetDeck(){
		deck = mock(Deck.class);

		game.setDeck(deck);
		
		assertSame(deck, game.getDeck());
		
	}
	
	@Test
	public void testGetPlayer1(){
		Player newPlayer = mock(Player.class);
		game.setPlayer1(newPlayer);
		
		assertSame(newPlayer, game.getPlayer1());
	}
	
	@Test
	public void testGetPlayer2(){
		Player newPlayer = mock(Player.class);
		game.setPlayer2(newPlayer);
		
		assertSame(newPlayer, game.getPlayer2());
	}

	@Test
	public void testGetDeck(){
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffleDeck();
		
		game.setDeck(deck);
		
		assertSame(deck, game.getDeck());
	}
	
}

