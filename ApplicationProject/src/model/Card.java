
package model;

import java.util.ArrayList;

/**
 *Application creates a standard 52 card deck, shuffles the cards, and deals a specified amount of cards from the deck. Apllication uses String ArrayLists in order to fulfill these tasks
 *    @author Elizabeth Nguyen oep957
 */

public class Card 
{
	    /**
	     * The class creates an arrayList of string that represent card values. Fills the arraylist by going through two predefined arraylists with the ranks and suits of the cards
	     * @return ArrayList String
	     */
	    public static ArrayList<String> getDeck()  //Method that creates a deck of cards by making the suits and ranks as strings that are added to an arraylist. The arraylist is then returned
	    {
	    	String [] suits = {"\u2660", "\u2665", "\u2666", "\u2663"}; //Fills an array with the four suit values
	        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", 
	            "8", "9", "10", "Jack", "Queen", "King"};        //Fills an array with the 13 card ranks

	        ArrayList<String> deck = new ArrayList<String>(52); //Initializes a String ArrayList called deck with a capacity of 52
	        
	        int i = 0; //Declares and initializes an integer with the value of 0
	        for (String suit : suits) //Enhanced for loop that goes through the suit array
	        { 
	            for (String rank : ranks) //Enhanced for loop that goes through the rank array
	            { 
	            	
	                deck.add(i, rank +  suit); //Adds the element at deck index i to the current rank and suit
	                i++; //Adds 1 to i
	            }
	        }
	        return deck; //Returns the deck ArrayList
	    }

	    /** The following method takes an arraylist and for loops through it then uses randomly generated numbers to switch cards and shuffle them
	     * @param deck arraylist String
	     */
	    public static void shuffleDeck(ArrayList<String> deck) //Method that goes through the deck arraylist (parameter) and switches the elements in the arraylist
	    {
	        for (int i = 0; i < deck.size(); i++) //For loop from 0 to the size of the deck arraylist
	        {
	            String savedCard = deck.get(i); //Sets the String savedCard variable to the current element
	            int randomIndex = (int) (Math.random() * deck.size()-1); //Sets the integer randomIndex variable to a random integer number using the Math.random and setting the limit of the Math.random to 0 and the deck size minus 1
	            deck.set(i,deck.get(randomIndex));//Sets the current element equal to the element of the randomIndex
	            deck.set(randomIndex,savedCard);//Sets the element of the randomIndex to the savedCard value
	        }
	    }

	    /**The following method takes an arraylist of cards and an integer value known as count. It will remove the amount of count cards from the parameter deck and add it into another arraylist of strings
	     * 
	     * @param deck-arrayList String will have elements removed
	     * @param count-the number of cards that must be removed from the deck parameter
	     * @return Arraylist String  this will consist of the cards removed from the deck parameter
	     */
	    public static ArrayList<String> dealCards(ArrayList<String> deck, int count) //Method that copies the elements from the deck arraylist from 0 to the count value
	    {
	        ArrayList<String> hand = new ArrayList<String>(); //Declares and initializes a String ArrayList called hand
	        
	        for (int i=0;i<count;i++) //For loops from 0 to the value of count so we know how many cards we are removing from the deck 
	            hand.add(deck.remove(0)); //Adds the removed card to the hand arraylist
	               
	        return hand; //Returns the hand arraylist
	    }
	}

