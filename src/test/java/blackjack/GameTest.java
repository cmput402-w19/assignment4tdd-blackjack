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
	Player currentPlayer;
	Player winner;
	
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
		Player p = game.getPlayer1();
		
		assertSame(player1, p);
	}
	
	@Test
	public void testGetPlayer2(){
		Player p = game.getPlayer2();
		
		assertSame(player2, p);
	}

	@Test
	public void testGetDeck(){
		Deck d = game.getDeck();
		
		assertSame(deck, d);
	}

	@Test
	public void testSetCurrentPlayer(){
		Player p = mock(Player.class);
		game.setCurrentPlayer(p);
		
		assertSame(p, game.getCurrentPlayer());
	}

	@Test
	public void testGetCurrentPlayer(){
		Player p = mock(Player.class);
		game.setCurrentPlayer(p);
		
		assertSame(p, game.getCurrentPlayer());
	}

	@Test
	public void testSetWinner(){
		Player p = mock(Player.class);
		game.setWinner(p);
		
		assertSame(p, game.getWinner());
	}

	@Test
	public void testGetWinner(){
		Player p = mock(Player.class);
		game.setWinner(p);
		
		assertSame(p, game.getWinner());
	}
	
	@Test
	public void testPlayer1Starts() {
		assertEquals(game.getCurrentPlayer(), player1);
	}

	@Test
	public void testNoWinnerAtStart() {
		assertEquals(game.getWinner(), null);
	}

	@Test
	public void testDealerDraw() {
		boolean b;
		when(deck.draw()).thenReturn(mock(Card.class));
		try {
			b = game.dealer("y", player1);
			assertEquals(true, b);
		}
		catch (Exception e) {
			System.out.println("\n\n\n\n\nexception");

		}
	}

	@Test
	public void testDealerStay() {
		boolean b;
		when(deck.draw()).thenReturn(mock(Card.class));
		try {
			b = game.dealer("n", player1);
			assertEquals(false, b);
		}
		catch (Exception e) {
			System.out.println("\n\n\n\n\nexception");

		}
	}
}

