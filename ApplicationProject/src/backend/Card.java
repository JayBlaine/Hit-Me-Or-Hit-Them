package backend;

public class Card {
	
	private int rank;
	private String suit;
	
	/**
	 * Constructor for the card class
	 * @param rank
	 * @param suit
	 */
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * mutator method that changes rank
	 * @param rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * mutator method that changes the suit
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	
	/**
	 * accessor that gets the current cards rank
	 * @return returns an int
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * accessor that gets the current cards suit
	 * @return returns a string
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * to string that changes the variables all into strings ; for viewing purposes
	 */
	public String toString() {
		return rank + " " + suit;
	}
	
}
