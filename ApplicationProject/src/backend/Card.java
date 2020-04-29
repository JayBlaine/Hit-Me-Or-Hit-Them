package backend;

public class Card {
	
	private int rank;
	private String suit;
	
	/**
	 * Constructor for card class 
	 * @param rank
	 * @param suit
	 */
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * mutator method for card class
	 * @param rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * mutator method for card class
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/**
	 * accessor method for card class
	 * @return returns an int that shows what rank the card is 
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * accessor method for card class
	 * @return returns a String that shows what suit the card is 
	 */
	public String getSuit() {
		return suit;
	}
	
	
	/**
	 * toString method, turns the variables into strings for reading
	 * @return returns a string
	 */
	public String toString() {
		return rank + " " + suit;
	}
	
}
