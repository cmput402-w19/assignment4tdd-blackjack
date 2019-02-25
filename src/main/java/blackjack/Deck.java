package blackjack;

import java.util.ArrayList;

public class Deck {

	// Instance	
	private ArrayList<Card> cards;
	
	// Constructor	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void createDeck() {
		//Generate Cards		
		for(Suit suit: Suit.values()) {
			for(Value value: Value.values())
				//Add cards to the deck
				this.cards.add(new Card(suit,value));
		}
	
	}
	
	// Returns the full deck size = 52	
	public int fulldeckSize() {
		return cards.size();
	}
	
	// Check if deck contains cards	
	public boolean deckContainsCards(Suit suit, Value value) {
		for (Card card: cards) {
			if (value == card.getValue() && suit == card.getSuit())
				return true;
		}
		return false;
	}
		   
}
