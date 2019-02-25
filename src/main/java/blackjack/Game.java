package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Deck deck;
	
	private Player player1;
	private Player player2;
	
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

	public Player getCurrentPlayer(){
		return null;
	}

	public int getCurrentPlayerNum(){
		return 0;
	}
	
	public void setDeck(Deck deck) {
		
	}

	public void setPlayer1(Player player1) {
		
	}

	public void setPlayer2(Player player2) {
		
	}

	public void setCurrentPlayer(Player player) {
		
	}

	// Code taken from Sarah Nadi's tictactoe need proper citation
	// currently unused
    public void promptNextPlayer(){
        switch(getCurrentPlayerNum()){
            case 1:
                System.out.println("It's player 1's turn. Take another card? [y/n] ");
                break;
            case 2:
                System.out.println("It's player 2's turn. Take another card? [y/n] ");
                break;

        }
}
	
	public void end(){
		
	}
	
	// Displays current state of the game
	public void print(){
		
	}
	
	public boolean dealer(String input, Player currentPlayer) throws InvalidInputException{
		if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
			// Give current player another card
			Card card = deck.draw();
			currentPlayer.getHand().addCard(card);
			return true;
		}
		
		else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
			return false;
			
		}else{
			throw new InvalidInputException("Temporary text");
		}
	}

	// Keep playing rounds when user enters desired input
	public void play(){
		
	}
	
	
	// Unfinished, idea is to let 
	public void playRound(){
		Scanner keyboardScanner = new Scanner(System.in);
		print();
		while(getPlayer1().getHand().getScore() < 21){
			System.out.println("Player1, Take another card? [y/n] ");
			String line = keyboardScanner.nextLine();
			boolean stay = dealer(line, getPlayer1());
			if(!stay){
				break;
			}
		}
		// If player over 21, they lose
		while(getPlayer2().getHand().getScore() < 21){
			System.out.println("Player2, Take another card? [y/n] ");
			String line = keyboardScanner.nextLine();
			boolean stay = dealer(line, getPlayer2());
			if(!stay){
				break;
			}
		}
		// If player over 21, they lose
		
		else{
			// Player with highest score wins the round
		}
		
		
	}
}
