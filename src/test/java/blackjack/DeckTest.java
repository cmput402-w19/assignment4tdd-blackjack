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
		Deck aDeck = new Deck();
		aDeck.createDeck();
		
		Card card1 = aDeck.getCard(0);
		Card card2 = aDeck.getCard(1);
		Card card3 = aDeck.getCard(2);
		
		assertEquals(aDeck.draw(), card1);
		assertEquals(aDeck.draw(), card2);
		assertEquals(aDeck.draw(), card3);
		
		assertEquals(aDeck.deckSize(), 49);
		
		
	}

}
