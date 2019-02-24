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
		String value = null;
		String suite = null;
		this.cards.add(new Card(value, suite));
	}
	
	public int deckSize() {
		return cards.size();
	}
	
//	public boolean deckContainsCards(String value, String suite) {
//		for (Card card: cards) {
//			if (value == card.value && suite == card.suite)
//				return true;
//		}
//		return false;
//	}
		   
}
