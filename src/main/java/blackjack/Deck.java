package blackjack;

import java.util.ArrayList;
import java.util.Random;

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
	
	public void shuffleDeck() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		// Generate random numbers
		Random random = new Random();
		int randomCard = 0;
		int deckSize = fulldeckSize();
		for(int i = 0; i < deckSize; i++) {
			randomCard = random.nextInt(deckSize) + 1;
			shuffledDeck.add(this.cards.get(randomCard));
			this.cards.remove(randomCard);
		}
		this.cards = shuffledDeck;
		
	}
	
	
	public String toString() {
		
		String cardlist = "";
		int i = 0;
		for(Card card: this.cards) {
			cardlist += "\n" + i + "-" + card.toString();
			i++;
		}
		return cardlist;
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
