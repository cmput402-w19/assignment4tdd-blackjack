package blackjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	
	@Test
	public void testCreateDeck() {
		Deck deck = new Deck();
		deck.createDeck();
		assertEquals(deck.fulldeckSize(),52);
		for (Suit suit: Suit.values()) {
			for (Value value: Value.values()) {
				assertTrue(deck.deckContainsCards(suit, value));
				
			}		
		}		
	}
	
}
