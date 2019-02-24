package blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Card {

	String suite;
	String value;
	HashMap<String, Integer> valueToScore = new HashMap<String, Integer>();
	
	public Card(String value, String suite){
		this.suite = suite;
		this.value = value;
		
		// Used later to populate HashMap
		Collection<String> collection = new ArrayList<String>();
		collection.add("jack");
		collection.add("queen");
		collection.add("king");
		
		//Populate valueToScore HashMap
		int i = 1;
		while(i<11){
			this.valueToScore.put(Integer.toString(i), i);
			i++;
		}
		for(String s : collection){
			valueToScore.put(s,10);
		}
		
		this.valueToScore.put("ace", 11);
			
	}
	
	@Override
	public boolean equals(Object o){
		
		if(!(o instanceof Card)){
			return false;
		}
		
		Card card = (Card) o;
		
		if(!(this.suite.equals(card.suite))){
			return false;
		}
		
		if(!(this.value.equals(card.value))){
			return false;
		}
		
		return true;
	}
	
	public int getScore() {
		return this.valueToScore.get(this.value);
	}

}
