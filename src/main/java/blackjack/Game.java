package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Deck deck;
	
	private Player player1;
	private Player player2;

	private Player currentPlayer;
	private Player winner;
	private boolean draw;

	public Game(Deck deck, Player player1, Player player2) {
		this.deck = deck;
		this.player1 = player1;
		this.player2 = player2;

		this.currentPlayer = player1;
		this.winner = null;
		this.draw = false;
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

	public boolean getDraw() {
		return this.draw;
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

	public void setDraw(boolean b) {
		this.draw = b;
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
		String p1Str = "Player 1's hand has " 
			+ this.player1.getHand().getScore()
			+ ".";
		String p2Str = "Player 2's hand has " 
			+ this.player2.getHand().getScore()
			+ ".\n" ;

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

	// true: can draw again
	// false: unable to draw again
	public boolean doTurn(String line) {
		try {
			boolean stay = deal(line, this.currentPlayer);
			if(!stay){
				return false;
			}
			if (this.currentPlayer.getHand().getScore() > 21) {
				Player p = null;
				if (this.currentPlayer == player1) {
					p = player2;
				}
				else {
					p = player1;
				}					
				this.winner = p;
				return false;
			}
			else {
				return true;
			}
		}
		
		catch (InvalidInputException e) {
			System.out.println("Error: invalid input.");
			return true;
		}
	}
	
	// play for the current player's drawing round of the game
	public void playRound() {
		Scanner keyboardScanner = new Scanner(System.in);
		boolean repeat = true;

		// repeat until the player can't anymore.
		while(repeat) {
			printStatus();
			promptNextPlayer();
			String line = keyboardScanner.nextLine();
			repeat = doTurn(line);
		}
		nextPlayer();

		// if looped back to player 1, then everyone has had their turn, so end this game
		if(this.currentPlayer == player1) {
			calculateWinner();
		};
	}

	public void nextPlayer() {
		Player p = (this.currentPlayer == player1 ? player2 : player1);
		this.currentPlayer = p;
	}

	public int getWinnerNum() {
		int winNum = 0;
		if (winner == player1) {
			winNum = 1;
		}
		else {
			winNum = 2;
		}
		return winNum;
	}

	public void calculateWinner() {
		if (player1.getHand().getScore() > player2.getHand().getScore()) {
			winner = player1; 
		}
		else {
			winner = player2;
		}
		System.out.println("Player " + getWinnerNum() + " wins!");	
	}

    public static void main(String args[]){
		// setup
		Deck deck = new Deck();		
		deck.createDeck();
		deck.shuffleDeck();
		ArrayList<ArrayList<Card>> cardsList = deck.dealCards();
		Player player1 = new Player(new Hand(cardsList.get(0)));
		Player player2 = new Player(new Hand(cardsList.get(1)));

		Game game = new Game(deck, player1, player2);

		while (game.getWinner() == null) {
			game.playRound();
		};
	}
}
