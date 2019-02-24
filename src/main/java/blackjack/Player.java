package blackjack;

public class Player {
	private Hand hand;
	private int wins;
	private int losses;
	private int ties;
	
	public Player(Hand hand){
		this.hand = hand;
		this.wins = 0;
		this.losses = 0;
		this.ties = 0;
	}
	
	public Hand getHand(){
		return this.hand;
	}
	
	public int getWins(){
		return this.wins;
	}
	
	public int getLosses(){
		return this.losses;
	}
	
	public int getTies(){
		return this.ties;
	}
	
	public void setHand(Hand hand){
		this.hand = hand;
		
	}
	
	public void setWins(int wins){
		
	}
	
	public void setLosses(int losses){
		
	}
	
	public void setTies(int ties){
		
	}
}
