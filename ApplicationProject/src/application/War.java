package application;

import java.util.ArrayList;

/**
 * The following class contains the logic used for the game of War. It is called by the WarController class
 * @author Elizabeth Nguyen oep957
 *
 */

public class War 
{
	
	/**
	 * Returns the String value of the size of a deck. The returned value is for lblpDeck and lbldDeck
	 * @param deck ArrayList<String>
	 * @return ret String
	 */
	public static String getDeckSize(ArrayList<String> deck)
	{
		String ret="";
		
		ret=Integer.toString(deck.size());
		
		return ret;
				
	}
	
	
	
	/**
	 * Checks if the player or computer has a higher value card or equal value card
	 * @param player String
	 * @param computer String
	 * @return playerWins int
	 */
	public static int checkWinner(String player, String computer)
	{
		//if playerWins is 0 then they lost, if one then they won, if 2 then its a draw and they must do war -EMN 03-21-2020
		int playerWins=0;
		String playerCard="";
		String comCard="";
		int intPlayerCard=0;
		int intcomCard=0;
		
		//Removing the suit value because we focus only on the rank value -EMN 03-21-2020
		playerCard=player.substring(0,1);
		comCard=computer.substring(0,1);
		
		//Checking if the player card is any of the face cards -EMN 03-21-2020
		if(playerCard.equals("A")|| playerCard.equals("K")||playerCard.equals("Q")||playerCard.equals("J"))
		{
			switch(playerCard)
			{
			case("A"): //Nothing beats an Ace so we have to check if the computer has an Ace which would mean there is a tie -EMN 03-21-2020
				if(comCard.equals("A"))
				{
					playerWins=2; //Both cards are of equal value -EMN 03-21-2020
				}
				else //If the computer has a card that is anything but an Ace then they automatically lose -EMN 03-21-2020
				{
					playerWins=1;
				}
			break;
			case("K"): //Only an Ace can beat a King -EMN 03-21-2020
				if(comCard.equals("A"))
				{
					playerWins=0; //Player loses 
				}
				else if (comCard.equals("K"))
				{
					playerWins=2; //Tie -EMN 03-21-2020
				}
				else //If the computer card is anything else then they the player wins -EMN 03-21-2020
				{
					playerWins=1;
				}
			break;
			case("Q"): //Only an Ace or King beats a Queen -EMN 03-21-2020
			
				if(comCard.equals("K")||comCard.equals("A")) //The computer has a higher value card -EMN 03-21-2020
				{
					playerWins=0; //Player loses -EMN 03-21-2020
				}
				else if (comCard.equals("Q")) 
				{
					playerWins=2; //Tie -EMN 03-21-2020
				}
				else
				{
					playerWins=1; //Player wins -EMN 03-21-2020
				}
			break;
			case("J"): //Any face value card beats Jack -EMN 03-21-2020
				if(comCard.equals("A")||comCard.equals("K")||comCard.equals("Q")||comCard.equals("J"))
				{
					playerWins=0; //Player loses -EMN 03-21-2020
				}
				else if (comCard.equals("J"))
				{
					playerWins=2; //Tie -EMN 03-21-2020
				}
				else
				{
					playerWins=1; //Player wins -EMN 03-21-2020
				}
			break;
			}

		}
		
		else //Player has a numerical value card -EMN 03-21-2020
		{
			intPlayerCard=Integer.parseInt(playerCard); //Getting the numerical value of the string -EMN 03-21-2020

			
			if(comCard.equals("A")||comCard.equals("K")||comCard.equals("Q")||comCard.equals("J")) //Checking if the computer has a face value card -EMN 03-21-2020
			{
				playerWins=0; //If the computer has a face value card they automatically win -EMN 03-21-2020
			}
			else //The computer does not have a face value card they have a numerical value card -EMN 03-21-2020
			{
				intcomCard=Integer.parseInt(comCard); //Getting the numerical value of the string -EMN 03-21-2020
				
				if(intPlayerCard==intcomCard) //If the cards are equal value then its a tie -EMN 03-21-2020
				{
					playerWins=2;
				}
				else if(intPlayerCard>intcomCard) //The player has a higher value card so the win -EMN 03-21-2020
				{
					playerWins=1;
				}
				else //The computer has a higher value card so the player loses -EMN 03-21-2020
				{
					playerWins=0;
				}
			}
		}
		return playerWins; //Returning the value of playerWins -EMN 03-21-2020

	}
	
	
}
