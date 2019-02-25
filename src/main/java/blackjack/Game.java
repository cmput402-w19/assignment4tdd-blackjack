package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Deck deck;
	
	private Player player1;
	private Player player2;

	private Player currentPlayer;
	private Player winner;

	public Game(Deck deck, Player player1, Player player2) {
		this.deck = deck;
		this.player1 = player1;
		this.player2 = player2;

		this.currentPlayer = player1;
		this.winner = null;
	}
	
	public Player getPlayer1(){
		return this.player1;
	}

	public Player getPlayer2(){
		return this.player2;
	}

	public Deck getDeck(){
		return this.deck;
	}

	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}

	public Player getWinner() {
		return this.winner;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}
	public void setWinner(Player player) {
		this.winner = player;
	}

	// Code taken from Sarah Nadi's tictactoe need proper citation
	// currently unused
    public void promptNextPlayer(){
        switch(0){
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
		System.out.println("hello");
		
	}
	
	
	// Unfinished, idea is to let 
	public void playRound(){
		Scanner keyboardScanner = new Scanner(System.in);
		String resp = null;
		print();

		// player 1's turn
		while(resp != "n"){
			System.out.println("Player1, Take another card? [y/n] ");
			String line = keyboardScanner.nextLine();

			try {
				boolean stay = dealer(line, this.player1);
				if(!stay){
					break;
				}
				if (this.player1.getHand().getScore() > 21) {
					System.out.println("Player 1 is above 21. Player 1 wins!");
					break;
				}
			}
			
			catch (InvalidInputException e) {
				System.out.println("Error: invalid input.");
			}
		}
		resp = null;
		// player 2's turn
		while(resp != "n"){
			System.out.println("Player2, Take another card? [y/n] ");
			String line = keyboardScanner.nextLine();
			try {
				boolean stay = dealer(line, this.player2);
				if(!stay){
					break;
				}
				if (this.player2.getHand().getScore() > 21) {
					System.out.println("Player 2 is above 21. Player 1 wins!");
					break;
				}
			}
			catch (InvalidInputException e) {
				System.out.println("Error: invalid input.");
			}
		}


		// find out who has a higher hand < 21
	}

    public static void main(String args[]){
		Deck deck = new Deck();
		Player player1;
		Player player2;
		
		deck.createDeck();
		deck.shuffleDeck();
		ArrayList<ArrayList<Card>> cardsList = new ArrayList<ArrayList<Card>>();
		cardsList = deck.dealCards();
		
		Hand hand1 = new Hand(cardsList.get(0));
		Hand hand2 = new Hand(cardsList.get(1));
		
		player1 = new Player(hand1);
		player2 = new Player(hand2);

		Game game = new Game(deck, player1, player2);

		game.playRound();
	}
}
