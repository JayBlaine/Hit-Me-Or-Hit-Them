		package model;

		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.Collections;
		import java.util.Deque;
		import java.util.LinkedList;
		import java.util.Random;
		import backend.Card;

		/**
		 * The following class contains the logic used for the game of Poker. It is called by the PokerController class
		 * @author Gage Nichols gnc042
		 * Joseph D'Amico fep771 integrated Poker.java and PokerController.java together
		 */
		public class Poker {
			
			static int playerHighCard = 1;
			static int cpuHighCard = 1;
			
			private static Deque<Card> playerHand = new LinkedList<Card>();
			private static Deque<Card> cpuHand = new  LinkedList<Card>();
			
			Random rand = new Random();
			static Card playerCard = new Card(0, "");
			static Card cpuCard = new Card(0, "");
			
			
			/**
			 * Makes a deck of cards and deals hands. The returned value is the winner
			 * @return result String
			 */
			public static String dealCards(Deque<Card> pHand, Deque<Card> cHand) {
				
				playerHand = pHand;
				cpuHand = cHand;
				
				System.out.println("User: " + playerHand.toString());
				System.out.println("CPU: " + cpuHand.toString());
				
				int playerHandRank = checkPlayerHand();
				int cpuHandRank = checkCPUHand(cpuHand);
				String cpuResult = "";
				String playerResult = "";
				
				if(cpuHandRank == 1) cpuResult = "high card";
				if(cpuHandRank == 2) cpuResult = "pair";
				if(cpuHandRank == 3) cpuResult = "2 pair";
				if(cpuHandRank == 4) cpuResult = "3 of a kind";
				if(cpuHandRank == 5) cpuResult = "straight";
				if(cpuHandRank == 6) cpuResult = "flush";
				if(cpuHandRank == 7) cpuResult = "full house";
				if(cpuHandRank == 8) cpuResult = "4 of a kind";
				if(cpuHandRank == 9) cpuResult = "straight flush";
				
				if(playerHandRank == 1) playerResult = "high card";
				if(playerHandRank == 2) playerResult = "pair";
				if(playerHandRank == 3) playerResult = "2 pair";
				if(playerHandRank == 4) playerResult = "3 of a kind";
				if(playerHandRank == 5) playerResult = "straight";
				if(playerHandRank == 6) playerResult = "flush";
				if(playerHandRank == 7) playerResult = "full house";
				if(playerHandRank == 8) playerResult = "4 of a kind";
				if(playerHandRank == 9) playerResult = "straight flush";
				

				System.out.println("User high card: "+playerHighCard);
				System.out.println("CPU high card: "+cpuHighCard);
				
				String result = checkWinner(playerHandRank, cpuHandRank);
				
				String victory = "Player Hand: " + playerResult + "\nCPU Hand: " + cpuResult + "\nThe result is: " + result +"!";
				
				return victory;
				
			}
			
			
			/**
			 * Returns the String value of the winner. Passes in hand rankings and calculates the winner
			 * @param userHand int
			 * @param cpuHand int
			 * @return winner String
			 */
			public static String checkWinner(int userHand, int cpuHand) {
				
				String winner = "";
				
				if (userHand > cpuHand) 
				{
					winner = "User";
				} else if(cpuHand > userHand)
				{
					winner = "CPU";
				} else if(userHand == cpuHand)
				{
					if(playerHighCard > cpuHighCard)
					{
						winner = "User";
					} else if(cpuHighCard > playerHighCard)
					{
						winner = "CPU";
					} else if(cpuHighCard == playerHighCard)
					{
						winner = "tie";
					} else
					{
						winner = "Great you broke the program";
					}
					
				} else
				{
					winner = "How did you get here?";
				}
				
				
				return winner;
			}
			
			/*
			 * Might need this later
			 *
			public void switchSuit(String suit) {
				switch(suit) {
				case "Hearts":
					
					break;
				case "Spades":
				
					break;
				case "Diamonds":
					
					break;
				case "Clubs":
					
					break;
				}//end of switch statement
			}
			*/
			
			/**
			 * Returns the integer value of the hand ranking. Hand ranking based off of the 9 possible hands
			 * with 9 being the best possible hand and 1 being the worst
			 * @return handRank int
			 */
			public static int checkCPUHand(Deque<Card> cpuHand) {
				
				boolean matchPair = false; // if there's a pair
				boolean matchThree = false; // if there's a three of a kind
				int highCard = 1;
				int handRank = 1;
				int match3 = 99; // what the three of a kind is (set outside card range to avoid logic error)
				int match2 = 99; // what the pair is (set outside card range to avoid logic error)
				int count = 0;
				int i = 0;
				boolean checkCPUSuits = false; // boolean for if all the suits are the same
				int[] cpuRankArr = new int[5]; // integer array of card ranks
				String[] cpuSuitArr = new String[5]; // String array of the cards suits
				
				//int[] testRankArr = new int[]{1,1,2,2,5};
				//String[] testSuitArr = new String[]{"Hearts","Spades","Spades","Spades","Spades"};
				
				/*
				 * Straight flush     returns 9 
				 * 4 of a kind        returns 8 
				 * full house         returns 7 
				 * flush              returns 6 
				 * straight           returns 5 
				 * 3 of a kind        returns 4
				 * 2 pair             returns 3 
				 * pair               returns 2
				 * high card          returns 1 
				 */
				
				//populate the arrays
				for(i = 0; i < 5; i++) 
				{
					
					cpuCard = cpuHand.peek();
					cpuRankArr[i] = cpuCard.getRank();
					cpuSuitArr[i] = cpuCard.getSuit();
					//System.out.println(playerCard.getSuit());
					cpuHand.remove();
					
				}
				
				// check if all of the suits are the same
				for(i = 0; i < 5; i++)
				{
					
					try 
					{
						String temp1 = cpuSuitArr[i+1];
						if(cpuSuitArr[i].equals(temp1)) 
						{
							count++;
						}
						if(count == 4)
						{
							checkCPUSuits = true;
						}
					} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				}
				
				//System.out.println("Suits match: "+checkCPUSuits);
				
				// sort the array
				Arrays.sort(cpuRankArr);
				// the highest card is now the last index
				cpuHighCard = cpuRankArr[4];
				
				// check for a straight
				try {
					for(i =0; i <5 ;i++)
					{
						
						int temp = cpuRankArr[i+1];
						if(cpuRankArr[i]==temp-1)
						{
							count++;
						}
						if(count==4)
						{
							if(handRank < 5)
							{
								handRank = 5;
							}
						}			
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				// four of a kind
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(cpuRankArr[i]==cpuRankArr[i+1])
						{
							count++;
						} else {
							count =0;
						}
						if(count==3)
						{
							if(handRank < 8)
							{
								handRank = 8;
							}
						}			
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				// three of a kind
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(cpuRankArr[i]== cpuRankArr[i+1]) // 0 & 1 equal
						{
							count++; // count goes up
						
						if(count==1) // if there's a pair
						{
							int temp = cpuRankArr[i+1]; // equal to second element
							if(temp == cpuRankArr[i+2]) // if second element equals third element
							{
								match3 = cpuRankArr[i+2]; // match3 = third element
								matchThree = true;
								//System.out.println("Matched 3: "+ match3);
								if(handRank < 4)
								{
									handRank = 4;
								} 
							} else {
								count = 0;
							}
							
							
						}
						}
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				//System.out.println("Three match: " + matchThree);
			
				
				// pair
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(cpuRankArr[i]==cpuRankArr[i+1] && cpuRankArr[i] != match3)
						{
							count++;
						
							if(count==1)
							{
								
								match2 = cpuRankArr[i];
								//System.out.println("Matched 2: " + match2);
								//System.out.println("Matched 3 is: " + match3);
								if(match2 != match3)
								{
									matchPair = true;
								}
								if(handRank < 2) 
								{
									handRank = 2;
								}
							}
							
						}
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				//System.out.println("Two match: " + matchPair);
				
				// Two pair
				try {
					
					for(i = 0; i < 5; i++) 
					{
						for(int j = i + 1; j < 5; j++)
						{
							if(cpuRankArr[i]==cpuRankArr[j] && cpuRankArr[i] != match2 && matchThree != true)
							{
								count++;
								//System.out.println("Count in 2 pair = " + count);
							}
						}
						if(count==1)
						{
							if(handRank < 3)
							{
								handRank = 3;
							}
						}
					}
			
				}catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				
				
				//System.out.println("Pair = " + matchPair + " Three is = " + matchThree);
				
				// if it's a straight and all of the suits are the same = straight flush
				if(handRank == 5 && checkCPUSuits == true) 
				{
					handRank = 9;
				}
				// if there's a 3 of a kind and a pair it's a full house
				if(matchPair == true 
						&& matchThree == true
						&& handRank < 7)
				{
					handRank = 7;
				}
				// if no matched but all the same suit
				if(checkCPUSuits == true && handRank < 6)
				{
					handRank = 6;
				}
				
				/*
				 * Straight flush     returns 9 
				 * 4 of a kind        returns 8 
				 * full house         returns 7 
				 * flush              returns 6 
				 * straight           returns 5 
				 * 3 of a kind        returns 4
				 * 2 pair             returns 3 
				 * pair               returns 2
				 * high card          returns 1 
				 */
				
				System.out.println("CPU hand rank: " + handRank);
				
				
				return handRank;
			}
			
			
			/**
			 * Returns the integer value of the hand ranking. Hand ranking based off of the 9 possible hands
			 * with 9 being the best possible hand and 1 being the worst
			 * @return handRank int
			 */
			public static int checkPlayerHand() {
				
				
				
				boolean matchPair = false; // if there's a pair
				boolean matchThree = false; // if there's a 3 of a kind
				int highCard = 1;
				int handRank = 1;
				int match3 = 99; // value of 3 of a kind (set outside card value to avoid logic error)
				int match2 = 99; // value of pair (set outside card value to avoid logic error)
				int count = 0;
				int i = 0;
				boolean checkPlayerSuits = false; // if all of the suits are the same
				int[] playerRankArr = new int[5]; // array to hold card ranks
				String[] playerSuitArr = new String[5]; // array to hold card suits
				
				//int[] testRankArr = new int[]{1,1,2,2,5};
				//String[] testSuitArr = new String[]{"Hearts","Spades","Spades","Spades","Spades"};
				
				
				// populate the arrays
				for(i = 0; i < 5; i++) 
				{
					
					playerCard = playerHand.peek();
					playerRankArr[i] = playerCard.getRank();
					playerSuitArr[i] = playerCard.getSuit();
					//System.out.println(playerCard.getSuit());
					playerHand.remove();
					
				}
				
				// check if all of the suits are the same way
				for(i = 0; i < 5; i++)
				{
					
					try 
					{
						String temp1 = playerSuitArr[i+1];
						if(playerSuitArr[i].equals(temp1)) 
						{
							count++;
						}
						if(count == 4)
						{
							checkPlayerSuits = true;
						}
					} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				}
				
				//System.out.println("Suits match: "+checkPlayerSuits);
				
				// sort the rank array
				Arrays.sort(playerRankArr);
				// last index is now the greatest value
				playerHighCard = playerRankArr[4];
				
				// check for a straight
				try {
					for(i =0; i <5 ;i++)
					{
						
						int temp = playerRankArr[i+1];
						if(playerRankArr[i]==temp-1)
						{
							count++;
						}
						if(count==4)
						{
							if(handRank < 5)
							{
								handRank = 5;
							}
						}			
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				// four of a kind
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(playerRankArr[i]==playerRankArr[i+1])
						{
							count++;
						}
						if(count==3)
						{
							if(handRank < 8)
							{
								handRank = 8;
							}
						}			
					}
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				// three of a kind
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(playerRankArr[i]== playerRankArr[i+1]) // 0 & 1 equal
						{
							count++; // count goes up
						
						if(count==1) // if there's a pair
						{
							int temp = playerRankArr[i+1]; // equal to second element
							if(temp == playerRankArr[i+2]) // if second element equals third element
							{
								match3 = playerRankArr[i+2]; // match3 = third element
								matchThree = true;
								//System.out.println("Matched 3: "+ match3);
								if(handRank < 4)
								{
									handRank = 4;
								} 
							} else {
								count = 0;
							}
							
							
						}
						}
					}
					
					
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				//System.out.println("Three match: " + matchThree);
			
				
				// pair
				try {
					for(i =0; i <5 ;i++)
					{
						
						if(playerRankArr[i]==playerRankArr[i+1] && playerRankArr[i] != match3)
						{
							count++;
						
							if(count==1)
							{
								
								match2 = playerRankArr[i];
								//System.out.println("Matched 2: " + match2);
								//System.out.println("Matched 3 is: " + match3);
								if(match2 != match3)
								{
									matchPair = true;
								}
								if(handRank < 2) 
								{
									handRank = 2;
								}
							}
							
						}
					}
					
				} catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				//System.out.println("Two match: " + matchPair);
				
				// Two pair
				try {
					
					for(i = 0; i < 5; i++) 
					{
						for(int j = i + 1; j < 5; j++)
						{
							if(playerRankArr[i]==playerRankArr[j] && playerRankArr[i] != match2 && matchThree != true)
							{
								count++;
								//System.out.println("Count in 2 pair = " + count);
							}
						}
						if(count==1)
						{
							if(handRank < 3)
							{
								handRank = 3;
							}
						}
					}
					
					
			
				}catch(ArrayIndexOutOfBoundsException e) {count = 0;}
				
				System.out.println("Pair = " + matchPair + " Three is = " + matchThree);
				
				// if it's a straight and all of the suits are the same = straight flush
				if(handRank == 5 && checkPlayerSuits == true) 
				{
					handRank = 9;
				}
				// if there's a 3 of a kind and a pair it's a full house
				if(matchPair == true 
						&& matchThree == true
						&& handRank < 7)
				{
					handRank = 7;
				}
				// if no matched but all the same suit
				if(checkPlayerSuits == true && handRank < 6)
				{
					handRank = 6;
				}
				
				/*
				 * Straight flush     returns 9 
				 * 4 of a kind        returns 8 
				 * full house         returns 7 
				 * flush              returns 6 
				 * straight           returns 5 
				 * 3 of a kind        returns 4
				 * 2 pair             returns 3 
				 * pair               returns 2
				 * high card          returns 1 
				 */
				
				System.out.println("Player hand rank: " + handRank);
				
				
				return handRank;
			}
			
			
		}


		//need to check hands
				/*
				 * Stright flush
				 * 4 of a kind
				 * full house
				 * flush
				 * straight 
				 * 3 of a kind
				 * 2 pair
				 * pair
				 * high card
				 */
				
				/*
				 * Straight flush - straight with all the same suit
				 * Ace is high or low but cannot wrap around
				 * A-2-3-4-5 or A-k-Q-J-10 or okay but K-A-2-3-4 is not
				 * Ace high straight flush is the best possible hand called a Royal Flush
				 */
				
				/*
				 * 4 of a kind - four cards of the same rank
				 * if both players have this winner is decided by which 
				 * 4 are higher
				 */
				
				/*
				 * full house - 3 of a kind and a pair
				 * ties are broken by first three of a kind and then the pair
				 */
				
				/*
				 * Flush - all cards are the same suit
				 * in a tie go with high card
				 */
				
				/*
				 * Straight - 5 cards are in order
				 * not the same suit and may not wrap around
				 * in a tie highest straight wins
				 * if both straight are the same then its a tie
				 */
				
				/*
				 * 3 of a kind - three cards of the same rank 
				 * matched with 2 cards that are not a pair
				 * if a tie then the highest 3 of a kind wins
				 */
				
				/*
				 * 2 pair - 2 pairs and a random 5th card
				 * ties broken by highest pair
				 */
				
				/*
				 * pair - two cards of the same rank
				 * 3 other cards have no correlation
				 * tie broken by highest pair
				 */
				
				/*
				 * high card - all cards have no correlation
				 * whichever card holds the highest value
				 */
