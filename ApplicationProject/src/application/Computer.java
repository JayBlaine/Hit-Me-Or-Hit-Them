package application;

import java.util.ArrayList;

public class Computer {
	
	private Card deck;
	
	public Computer(int diff) {
		//1 for easy, 2 for medium, 3 for hard
		
		deck = new Card();
		double implementChaos = Math.random();
		double responseTime;
		
		switch (diff) {
			case 1:
				responseTime = implementChaos;
			case 2:
				responseTime = implementChaos * 0.5;
			case 3:
				responseTime = implementChaos * 0.33;
		}
	}
	
	public ArrayList getComputerDeck() {
		return deck.getDeck();
	}
	

}
