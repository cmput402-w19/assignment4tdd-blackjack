package blackjack;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	
	@Test
	public void testShuffleDeck() {
		Deck originalDeck = new Deck();
		originalDeck.createDeck();

		Deck shuffledDeck = new Deck();
		shuffledDeck.createDeck();
		
		assertTrue(originalDeck.toString().equals(shuffledDeck.toString()));
		
		shuffledDeck.shuffleDeck();
		System.out.println(shuffledDeck);
		assertFalse(originalDeck.toString().equals(shuffledDeck.toString()));
		
		
	}

}
