package blackjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	
	@Test
	public void testCreateDeck() {
		Deck deck = new Deck();
		deck.createDeck();
		assertEquals(deck.deckSize(),52);
	}

}
