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
	
	@Override
	public boolean equals(Object o){
		
		if(!(o instanceof Card)){
			return false;
		}
		
		Card card = (Card) o;
		
		if(!(this.getSuit().equals(card.getSuit()))){
			return false;
		}
		
		if(!(this.value.equals(card.getValue()))){
			return false;
		}
		
		return true;
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
