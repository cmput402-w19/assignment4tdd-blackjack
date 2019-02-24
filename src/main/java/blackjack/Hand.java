package blackjack;

import java.util.ArrayList;
import java.util.Collection;
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
		Collection<Card> collection = this.cards;
		for(Card card : collection){
			score += card.getScore();
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
