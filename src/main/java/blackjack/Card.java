package blackjack;

public class Card {
	
	private Suit suit;
	private Value value;

	//Constructor
	public Card(Suit suit, Value value){
		this.suit = suit;
		this.value = value;

	}
	//Returns name of the suit and value
	public String toString() {
		return this.suit.toString() + ":"  + this.value.toString();
	}
	
	// Gets value of card	
	public Value getValue() {
		
		return this.value;
	}
	
	// Gets suit of card	
	public Suit getSuit() {
		return this.suit;
	}

}
