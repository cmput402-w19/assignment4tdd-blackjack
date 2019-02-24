package blackjack;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	
	public Hand(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	public int getScore(){
		return 0;
	}
	
	public int getCount(){
		return 0;
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
}
