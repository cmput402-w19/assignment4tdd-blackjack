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
		int deckSize = deckSize();
		for(int i = 0; i < deckSize; i++) {
			randomCard = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			shuffledDeck.add(this.cards.get(randomCard));
			this.cards.remove(randomCard);
		}
		this.cards = shuffledDeck;	
	}
	
	
	// Returns a string with contents in the deck	
	public String toString() {
		
		String cardlist = "";
		int i = 0;
		for(Card card: this.cards) {
			cardlist += "\n" + i + "-" + card.toString();
			i++;
		}
		return cardlist;
	}
	
	// Remove from the deck
	// Remove the index from deck	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	// Get a card form the deck
	// Add a card to the index of the deck	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	// Draws a card from the deck	
	public void draw(Deck aDeck){
		this.cards.add(aDeck.getCard(0));
		aDeck.removeCard(0);			
	}
		
	
	// Returns the full deck size = 52	
	public int deckSize() {
		return this.cards.size();
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
