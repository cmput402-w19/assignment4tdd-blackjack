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
	private final InputStream originalIn = System.in;
	
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
		System.setIn(originalIn);
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

		game.setPlayer2(p1);

		assertSame(p1, game.getPlayer2());
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
			System.out.println("\n\n\nexception");


		}
	}

	@Test (expected = InvalidInputException.class)
	public void testDealerInvalidInput() {
		boolean b;
		when(deck.draw()).thenReturn(mock(Card.class));
		try {
			b = game.deal("p", player1);
		}
		catch (InvalidInputException e) {
			// ignore. this is expected to happen
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

	@Test
	public void testNextPlayerWhenCurrentIs1() {
		game.nextPlayer();

		assertSame(player2, game.getCurrentPlayer());
	}

	@Test
	public void testNextPlayerWhenCurrentIs2() {
		game.setCurrentPlayer(player2);

		game.nextPlayer();

		assertSame(player1, game.getCurrentPlayer());
	}

	@Test
	public void testDoTurnForPlayer1Lose() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);

		// player 1 will have a score of 22 (>21), and thus
		// the other player wins the game
		when(h1.getScore()).thenReturn(22);

		assertFalse(game.doTurn("y"));
	}

	@Test
	public void testDoTurnForPlayer2Lose() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player2.getHand()).thenReturn(h2);

		game.setCurrentPlayer(player2);

		// player 2 will have a score of 22 (>21), and thus
		// the other player wins the game
		when(h2.getScore()).thenReturn(22);
		
		assertFalse(game.doTurn("y"));
	}

	@Test
	public void testDoTurnForPlayer2NoWinner() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player2.getHand()).thenReturn(h2);

		game.setCurrentPlayer(player2);

		// player 2 will have a score of 1 (<21), and thus
		// there is no winner and the player can
		// draw again
		when(h2.getScore()).thenReturn(1);

		assertTrue(game.doTurn("y"));
	}

	@Test
	public void testDoTurnForPlayer1NoWinner() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);

		game.setCurrentPlayer(player1);

		// player 1 will have a score of 1 (<21), and thus
		// there is no winner and the player can
		// draw again
		when(h1.getScore()).thenReturn(1);

		assertTrue(game.doTurn("y"));

	}

	@Test
	public void testDoTurnForPlayer1Pass() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player2.getHand()).thenReturn(h2);

		game.setCurrentPlayer(player1);

		when(h1.getScore()).thenReturn(1);

		assertFalse(game.doTurn("n"));

	}

	@Test
	public void testDoTurnForPlayer2Pass() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player2.getHand()).thenReturn(h2);

		game.setCurrentPlayer(player2);

		when(h2.getScore()).thenReturn(1);

		assertFalse(game.doTurn("n"));

	}

	@Test
	public void testDoTurnCatchException() {
		Hand h2 = mock(Hand.class);
		when(player2.getHand()).thenReturn(h2);

		game.setCurrentPlayer(player2);

		when(h2.getScore()).thenReturn(1);

		// exception handling in case of invalid input should
		// return true, as they can still do another turn.
		assertTrue(game.doTurn("p"));

	}

	@Test
	public void testGetWinnerNumP1() {
		game.setWinner(player1);
		assertEquals(1, game.getWinnerNum());

	}

	@Test
	public void testGetWinnerNumP2() {
		game.setWinner(player2);
		assertEquals(2, game.getWinnerNum());

	}

	@Test
	public void testplayRound() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		when(h1.getScore()).thenReturn(2);
		when(h2.getScore()).thenReturn(1);


		String input = "n\n";
		InputStream  in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		game.playRound();

		// check that player 1 finishes the turn
		assertSame(player2, game.getCurrentPlayer());
	}

	@Test
	public void testPlayRoundGameEnd() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);
		when(h1.getScore()).thenReturn(2);
		when(h2.getScore()).thenReturn(1);
		game.setCurrentPlayer(player2);


		String input = "n\n";
		InputStream  in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		game.playRound();

		// check that at the end of a game, 
		// (i.e. nextPlayer looped back to player 1), 
		// a winner sone chosen
		assertNotNull(game.getWinner());
		assertEquals(player1, game.getWinner());

	}

	@Test
	public void testCalculateWinnerPlayer1Wins() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		when(h1.getScore()).thenReturn(2);
		when(h2.getScore()).thenReturn(1);

		game.calculateWinner();

		assertSame(player1, game.getWinner());
		
	}

	@Test
	public void testCalculateWinnerTie() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		when(h1.getScore()).thenReturn(4);
		when(h2.getScore()).thenReturn(4);

		game.calculateWinner();

		assertTrue(game.getTie());
		
	}

	@Test
	public void testCalculateWinnerByElimination() {
		// test that a winner is returned
		// by this method if there already exists a winner
		// due to a player going over 21.
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		when(h1.getScore()).thenReturn(22);
		when(h2.getScore()).thenReturn(4);

		game.setWinner(player2);

		game.calculateWinner();

		assertSame(player2, game.getWinner());
		
	}

	@Test
	public void testGetTie() {
		boolean b = game.getTie();

		assertFalse(b);
		
	}

	@Test
	public void testSetTie() {
		game.setTie(true);

		assertTrue(game.getTie());
		
	}

	@Test
	public void testCalculateWinnerNoTie() {
		Hand h1 = mock(Hand.class);
		Hand h2 = mock(Hand.class);
		when(player1.getHand()).thenReturn(h1);
		when(player2.getHand()).thenReturn(h2);

		when(h1.getScore()).thenReturn(4);
		when(h2.getScore()).thenReturn(3);

		game.calculateWinner();

		assertFalse(game.getTie());
		
	}

	@Test
	public void testAskContinueTrue() {
		String input = "y\n";
		InputStream  in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertTrue(game.askContinue());
	}

	@Test
	public void testAskContinueFalse() {
		String input = "n\n";
		InputStream  in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertFalse(game.askContinue());

	}

}

