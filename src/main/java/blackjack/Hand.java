package blackjack;

import java.util.ArrayList;
import java.util.HashSet;

public class Hand {
	ArrayList<Card> cards;
	
	public Hand(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	@Override
    public boolean equals(Object o) {
		
		if(!(o instanceof Hand)){
			return false;
		}
		
		Hand newHand = (Hand) o;
		
		HashSet<Card> thisCards =  new HashSet<Card>(this.cards);
		HashSet<Card> newCards =  new HashSet<Card>(newHand.getCards());	
		
		if(!(thisCards.equals(newCards))){
			return false;
		}
		
		return true;
		
	}
	
	public int getScore(){
		int score = 0;
//		Collection<Card> collection = this.cards;
		for(Card card : this.cards){
			switch(card.getValue()) {
			case ACE: score += 1; break;
			case TWO: score += 2; break;
			case THREE: score += 3; break;
			case FOUR: score += 4; break;
			case FIVE: score += 5; break;
			case SIX: score += 6; break;
			case SEVEN: score += 7; break;
			case EIGHT: score += 8; break;
			case NINE: score += 9; break;
			case TEN: score += 10; break;
			case JACK: score += 10; break;
			case QUEEN: score += 10; break;
			case KING: score += 10; break;
			}
		}
		return score;
	}
	
	public int getCount(){
		return this.cards.size();
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
}
