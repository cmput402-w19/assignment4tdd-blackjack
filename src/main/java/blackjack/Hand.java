package blackjack;

import java.util.ArrayList;
import java.util.Collection;

public class Hand {
	ArrayList<Card> cards;
	
	public Hand(ArrayList<Card> cards){
		this.cards = cards;
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
