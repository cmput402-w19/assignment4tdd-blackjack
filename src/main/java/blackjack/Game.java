package blackjack;

import java.util.ArrayList;

public class Game {
	
	private Deck deck;
	
	private Player player1;
	private Player player2;
	
	private Player winner;
	
	public void Game(){
		deck.createDeck();
		deck.shuffleDeck();
		
		ArrayList<ArrayList<Card>> cardsList = new ArrayList<ArrayList<Card>>();
		cardsList = deck.dealCards();
		
		Hand hand1 = new Hand(cardsList.get(0));
		Hand hand2 = new Hand(cardsList.get(1));
		
		player1 = new Player(hand1);
		player2 = new Player(hand2);
	}
	
	public Player getPlayer1(){
		return null;
	}

	public Player getPlayer2(){
		return null;
	}

	public Deck getDeck(){
		return null;
	}

	public Player getWinner(){
		return null;
	}

	// Sets environment up for the game
	public void setUp(){
		
	}
	
	public void end(){
		
	}
	
	// Displays current state of the game
	public void print(){
		
	}

	public void play(){
	
	}

}
