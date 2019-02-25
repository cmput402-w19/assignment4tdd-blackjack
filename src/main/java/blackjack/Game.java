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
        if (this.currentPlayer == player1) {
			System.out.println("It is player 1's turn. Take another card? [y/n] ");
		}
		else if (this.currentPlayer == player2) {
			System.out.println("It is player 2's turn. Take another card? [y/n] ");
		}
	}
	
	// Displays current state of the game
	public void printStatus(){
		String p1Str = "Player 1 has " 
			+ this.player1.getHand().getScore()
			+ " in their hand.";
		String p2Str = "Player 2 has " 
			+ this.player2.getHand().getScore()
			+ " in their hand." ;

		System.out.println(p1Str);
		System.out.println(p2Str);
	}
	
	// Deals cards to current player for as long as they keep asking
	public boolean deal(String input, Player currentPlayer) throws InvalidInputException{
		if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
			// Give current player another card
			Card card = deck.draw();
			currentPlayer.getHand().addCard(card);
			return true;
		}
		
		else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
			return false;
			
		}else{
			throw new InvalidInputException("Invalid input!");
		}
	}

	// Keep playing rounds when user enters desired input
	public void play(){
		System.out.println("hello");
		
	}
	
	
	public void playRound(){
		Scanner keyboardScanner = new Scanner(System.in);
		String resp = null;
		while(resp != "n"){
			printStatus();
			promptNextPlayer();
			String line = keyboardScanner.nextLine();

			try {
				boolean stay = deal(line, this.currentPlayer);
				if(!stay){
					break;
				}
				if (this.player1.getHand().getScore() > 21) {
					Player p = null;
					if (this.currentPlayer == player1) {
						p = player2;
					}
					else if (this.currentPlayer == player2) {
						p = player1;
					}					
					this.winner = p;
					break;
				}
			}
			
			catch (InvalidInputException e) {
				System.out.println("Error: invalid input.");
			}
		}
		this.currentPlayer = (this.currentPlayer == player1 ? player2 : player1);
	}

    public static void main(String args[]){

		// setup
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

		while (game.getWinner() == null) {
			game.playRound();
		};
		Player winner = game.getWinner();
		int winNum = 0;
		if (winner == player1) {
			winNum = 1;
		}
		else if (winner == player2) {
			winNum = 2;
		}
		System.out.println("Player " + winNum + " wins!");
	}
}
