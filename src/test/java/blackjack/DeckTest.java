package blackjack;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	
	@Test
	public void testCreateDeck() {
		Deck deck = new Deck();
		deck.createDeck();
		assertEquals(deck.deckSize(),52);
		for (Suit suit: Suit.values()) {
			for (Value value: Value.values()) {
				assertTrue(deck.deckContainsCards(suit, value));
				
			}		
		}		
	}
	
	@Test
	public void testShuffleDeck() {
		Deck originalDeck = new Deck();
		originalDeck.createDeck();

		Deck shuffledDeck = new Deck();
		shuffledDeck.createDeck();
		
		assertTrue(originalDeck.toString().equals(shuffledDeck.toString()));
		
		shuffledDeck.shuffleDeck();
		assertFalse(originalDeck.toString().equals(shuffledDeck.toString()));
		
		
	}
	
	@Test
	public void testDraw() {
		Deck playingDeck = new Deck();
		playingDeck.createDeck();
		
		Deck aDeck = new Deck();
		aDeck.createDeck();
		
		aDeck.draw(playingDeck);
		aDeck.draw(playingDeck);
		aDeck.draw(playingDeck);
		
		assertNotEquals(aDeck.deckSize(), 51);
		
		
	}

}
