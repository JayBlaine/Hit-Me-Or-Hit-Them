package application;

import java.util.ArrayList;

public class Computer extends Card {
	
	private Card deck;
	private double responseTime;
	private int diff;
	private double implementChaos = Math.random();
	
	public Computer(int iDiff) {
		//1 for easy, 2 for medium, 3 for hard
		diff = iDiff;
		deck = new Card();
		
	}
	public void setDifficulty() {
		switch (diff) {
			case 1:
				responseTime = implementChaos + 1;
			case 2:
				responseTime = (implementChaos * 0.5) + 0.75;
			case 3:
				responseTime = (implementChaos * 0.33) + 0.5;
			}
	}
	public double getResponseTime() {
		return responseTime;}
	public void setResponseTime(double newTime) {
		responseTime = newTime;}
	public Card getComputerDeck() {
		return deck;}
	public void setDeck(Card newDeck) {
		deck = newDeck;}
	

}
