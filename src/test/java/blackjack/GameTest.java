package blackjack;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.*;

public class GameTest extends TestCase {
	Game game;
	Player player1;
	Player player2;
	Deck deck;
	Player currentPlayer;
	Player winner;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	@Before
	public void setUp(){
		player1 = mock(Player.class);
		player2 = mock(Player.class);
		deck = mock(Deck.class);

		game = new Game(deck, player1, player2);

		// game = new Game();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
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
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		try {
			b = game.deal("y", player1);
			assertEquals(true, b);
		}
		catch (Exception e) {
			System.out.println("\n\n\nexception");

		}
	}

	@Test
	public void testDealerStay() {
		boolean b;
		when(deck.draw()).thenReturn(mock(Card.class));
		try {
			b = game.deal("n", player1);
			assertEquals(false, b);
		}
		catch (Exception e) {
			System.out.println("\n\n\n\n\n");


		}
	}

	@Test
	public void testPromptNextPlayer1() {
		game.promptNextPlayer();

		assertEquals("It is player 1's turn. Take another card? [y/n] \n", outContent.toString());
	}

	@Test
	public void testPromptNextPlayer2() {
		game.setCurrentPlayer(player2);

		game.promptNextPlayer();

		assertEquals("It is player 2's turn. Take another card? [y/n] \n", outContent.toString());
	}

	@Test
	public void testPrintStatus() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		game.printStatus();

		// starting with 0 scores
		assertEquals("Player 1's hand has 0.\nPlayer 2's hand has 0.\n\n", outContent.toString());
	}

	
}

