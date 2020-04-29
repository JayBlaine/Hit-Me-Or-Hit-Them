package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The following class contains the action handlers for all the components on the warScreen.fxml. The class utilizes the War class and Card class for game logic.
 *  
 * @author Elizabeth Nguyen oep957
 * 
 * 03-21-2020
 */



/**
 * @author oep957
 *
 */
public class warController
{
	//Initializing the components, so we can add information and make them visible. -EMN 03-21-2020
	@FXML 
	private Rectangle pflip; //This is the player's flipped card. We toggle this as visible and invisible -EMN 03-21-2020
	@FXML
	private Rectangle dflip; //This is the opponent's flipped card. We toggle this as visible and invisible -EMN 03-21-2020
	@FXML
	private Rectangle pw1; //This is the player's first war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Rectangle pw2; //This is the player's second war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Rectangle pw3; //This is the player's third war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Rectangle dw1; //This is the computer's first war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Rectangle dw2; //This is the computer's second war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Rectangle dw3; //This is the computer's third war card. We make it visible when they press the war button -EMN 03-21-2020
	@FXML
	private Label lblp; //This is the label that contains the player's flipped card value -EMN 03-21-2020
	@FXML
	private Label lbld;  //This is the label that contains the computer's flipped card value -EMN 03-21-2020
	@FXML
	private Label lblpDeck; //This is the label that goes on top of the player's deck. It displays how many cards are in the player's deck. (Will decrement or add after the user presses the collect button) -EMN 03-21-2020
	@FXML
	private Label lbldDeck; //This is the label that goes on top of the computer's deck. It displays how many cards are in the computer's deck.(Will decrement or add after the user presses the collect button) -EMN 03-21-2020
	@FXML
	private Label lblpw1; //This is the label for the player's first war card. We make it visible when the second set of flipped cards are equal -EMN 03-21-2020
	@FXML
	private Label lblpw2; //This is the label for the player's second war card. We make it visible when both the player's and computer's first war cards are the same -EMN 03-21-2020
	@FXML
	private Label lblpw3; //This is the label for the player's third war card. We make it visible when both the player's and computer's second war cards are the same -EMN 03-21-2020
	@FXML
	private Label lbldw1; //This is the label for the computer's first war card. We make it visible when the second set of flipped cards are equal -EMN 03-21-2020
	@FXML
	private Label lbldw2; //This is the label for the computer's second war card. We make it visible when both the player's and computer's first war cards are the same -EMN 03-21-2020
	@FXML
	private Label lbldw3; //This is the label for the computer's third war card. We make it visible when both the player's and computer's second war cards are the same -EMN 03-21-2020
	@FXML
	private Label txtHelp; //Label that displays the help message or information on whether or not the user won or lost -EMN 03-21-2020
	@FXML
	private Button btnFlip; //Button that displays the computer's and player's top card -EMN 03-21-2020
	@FXML
	private Button btnCollect; //Button that checks if the computer or player won the round-EMN 03-21-2020
	@FXML
	private Button btnWar; //Button that fills the war cards and flip the next set of cards -EMN 03-21-2020
	@FXML
	private Button btnCollectWar; //Button that checks if the player or computer won war -EMN 03-21-2020
	@FXML
	private Button btnPlay; //Button that allows the player to play again. We should clear out the decks and refill them. Look at the playHandle method for more information -EMN 03-21-2020
	
	
	
	ArrayList<String> deck=Card.getDeck(); //Filling an arraylist to make a deck of cards -EMN 03-21-2020
	ArrayList<String> player= new ArrayList<String>(); //Arraylist that represents the player's deck of cards -EMN 03-21-2020
	ArrayList<String> computer=new ArrayList<String>(); //Arraylist that represents the computer's deck of cards -EMN-21-2020

	String ogPlayer=""; //When the computer and player go to war we must temporarily hold the value of the player's first flipped card -EMN 02-21-2020
	String ogCom=""; //When the computer and player go to war we must temporarily hold the value of the computer's first flipped card -EMN 02-21-2020
	
	
	/**
	 * We are preparing the deck of cards, adjusting the alignment for each label, and adjusting the font color of some of the label -EMN 03-21-2020
	 */
	@FXML
    private void initialize()
    {
		Card.shuffleDeck(deck);
		player=Card.dealCards(deck, 26);
		computer=Card.dealCards(deck, 26);
		lblpDeck.setText("26");
		lbldDeck.setText("26");
	
		lblpDeck.setTextFill(Color.WHITE);
		lbldDeck.setTextFill(Color.WHITE);
		
		lblpDeck.setAlignment(Pos.CENTER);
		lbldDeck.setAlignment(Pos.CENTER);
		
		lblp.setAlignment(Pos.CENTER);
		lbld.setAlignment(Pos.CENTER);
		lblpw1.setAlignment(Pos.CENTER);
		lblpw2.setAlignment(Pos.CENTER);
		lblpw3.setAlignment(Pos.CENTER);
		lbldw1.setAlignment(Pos.CENTER);
		lbldw2.setAlignment(Pos.CENTER);
		lbldw3.setAlignment(Pos.CENTER);

    }
	
	
	/**
	 * @param event
	 */
	@FXML
	private void playHandle(ActionEvent event)
	{
		//To refill the deck set deck=Card.getDeck, then use the Card.shuffleDeck to shuffle the cards, then to split the deck use the Card.dealCards. (An example of how these methods work is in the initialize method). 
		//You must also reset lblpDeck and lbldDeck. -EMN 03-21-2020
	}
	/**
	 * This is the event handler for btnFlip. We make the flipped cards visible (pflip and dflip) and fill the labels with the value of the top cards -EMN 03-21-2020
	 * @param event
	 */
	@FXML
	private void flipHandle(ActionEvent event)
    {
		txtHelp.setText("");
		txtHelp.setVisible(false);
		
		lblp.setText(player.get(0));
		lbld.setText(computer.get(0));
		
		pflip.setVisible(true);
		dflip.setVisible(true);

    }
	
	/**
	 * Event handler for btnWar
	 * @param event
	 */
	@FXML
	private void warHandle(ActionEvent event)
    {
		//Saving the original flipped card values -EMN 03-21-2020
		ogPlayer=lblp.getText();
		ogCom=lbld.getText();
		
		//Setting the values for all three of the face down war cards. They are the next three cards in the arraylist -EMN 03-21-2020
		lblpw1.setText(player.get(1));
		lblpw2.setText(player.get(2));
		lblpw3.setText(player.get(3));
		
		//Setting the labels invisible so we do not reveal the value of the cards -EMN 03-21-2020
		lblpw1.setVisible(false);
		lblpw2.setVisible(false);
		lblpw3.setVisible(false);
		
		//Making the war cards visible so the player knows that we have put their three cards face down -EMN 03-21-2020
		pw1.setVisible(true);
		pw2.setVisible(true);
		pw3.setVisible(true);
		
		//Setting the values for all three of the face down war cards. They are the next three cards in the arraylist -EMN 03-21-2020
		lbldw1.setText(computer.get(1));
		lbldw2.setText(computer.get(2));
		lbldw3.setText(computer.get(3));
		
		//Setting the labels invisible so we do not reveal the value of the cards -EMN 03-21-2020
		lbldw1.setVisible(false);
		lbldw2.setVisible(false);
		lbldw3.setVisible(false);
		
		//Making the war cards visible so the player knows that we have put their three cards face down -EMN 03-21-2020
		dw1.setVisible(true);
		dw2.setVisible(true);
		dw3.setVisible(true);
		
		//Setting the values for the second set of flipped cards -EMN 03-21-2020
		lblp.setText(player.get(4));
		lbld.setText(computer.get(4));
		
		//Making the flipped cards visible -EMN 03-21-2020
		pflip.setVisible(true);
		dflip.setVisible(true);
		
    }
	
	/**
	 * This is the event handler for btnCollecrWar. We are checking who wins war
	 * @param event
	 */
	@FXML
	private void collectWarHandle(ActionEvent event)
    {
		int playerWins=War.checkWinner(lblp.getText(),lbld.getText());
		
		if (playerWins==2) //The player and computer flipped equal value cards so we must flip the first face down cards (dw1 and pw1)
		{
			txtHelp.setText("You and the computer flipped the same value card! Now you must War");
			txtHelp.setVisible(true);
			
			pw1.setVisible(true);
			dw1.setVisible(true);
			
			 playerWins=War.checkWinner(lblpw1.getText(),lbldw1.getText()); //Checking if the first war cards are of equal value -EMN 03-21-2020
			 
			 if(playerWins==2) //This means the first set of war cards have equal value so we must flip the second set of war cards -EMN 03-21-2020
			 {
				pw2.setVisible(true);
				dw2.setVisible(true);
				lblpw1.setVisible(true);
				lbldw1.setVisible(true);
				
				playerWins=War.checkWinner(lblpw2.getText(),lbldw2.getText()); //Checking if the second war cards are of equal value -EMN 03-21-2020
				
				if(playerWins==2) //This means the first set of war cards have equal value so we must flip the third set of war cards -EMN 03-21-2020
				{
					pw3.setVisible(true);
					dw3.setVisible(true);
					lblpw2.setVisible(true);
					lbldw2.setVisible(true);
						
					playerWins=War.checkWinner(lblpw3.getText(),lbldw3.getText()); //Checking if the third war cards are of equal value -EMN 03-21-2020
					
					if (playerWins==1) //This means the player won -EMN 03-21-2020
					{
						txtHelp.setText("You Win! You get to keep your cards and the computer's cards!");
						txtHelp.setVisible(true);
						collectWarCards(true);
					}
					else //The player lost -EMN 03-21-2020
					{
						txtHelp.setText("You lose! The computer gets to keep your cards and its cards.");
						txtHelp.setVisible(true);
						collectWarCards(false);
					}

					
				}
				else if (playerWins==1) //This means the player won-EMN 03-21-2020
				{
					txtHelp.setText("You Win! You get to keep your cards and the computer's cards!");
					txtHelp.setVisible(true);
					collectWarCards(true);
				}
				else //This means the player lost -EMN 03-21-2020
				{
					txtHelp.setText("You lose! The computer gets to keep your cards and its cards.");
					txtHelp.setVisible(true);
					collectWarCards(false);
				}
			 }
			 else if (playerWins==1) //This means the player won -EMN 03-21-2020
			{
				txtHelp.setText("You Win! You get to keep your cards and the computer's cards!");
				txtHelp.setVisible(true);
				collectWarCards(true);
			}
			else //This means the player lost -EMN 03-21-2020
			{
				txtHelp.setText("You lose! The computer gets to keep your cards and its cards.");
				txtHelp.setVisible(true);
				collectWarCards(false);
			}
			
			
		}
		else if(playerWins==1) //This means the player won -EMN 03-21-2020
		{
			txtHelp.setText("You Win! You get to keep your cards and the computer's cards!");
			txtHelp.setVisible(true);
			collectWarCards(true);
		}
		else //This means the player lost -EMN 03-21-2020
		{
			txtHelp.setText("You lose! The computer gets to keep your cards and its cards.");
			txtHelp.setVisible(true);
			collectWarCards(false);
		}
		
		
    }
	/**
	 * This is the event handler for btnCollect
	 * @param event
	 */
	@FXML
	private void collectHandle(ActionEvent event)
    {
		int playerWins=War.checkWinner(lblp.getText(),lbld.getText()); //Checking who has the higher value flipped card
		
		if (playerWins==2) //The computer and player flipped equal value cards, so we enable btnWar and btnCollectWar so we can do the war logic -EMN 03-21-2020
		{
			txtHelp.setText("You and the computer flipped the same value card! Now you must War");
			txtHelp.setVisible(true);
			btnFlip.setVisible(false);
			btnWar.setVisible(true);
			btnCollect.setVisible(false);
			btnCollectWar.setVisible(true);
		}
		else if(playerWins==1) //The player won -EMN 03-21-2020
		{
			txtHelp.setText("You Win! You get to keep your card and the computer's card!");
			txtHelp.setVisible(true);
			collectCards(true);
		}
		else //The computer won -EMN 03-21-2020
		{
			txtHelp.setText("You lose! The computer gets to keep your card and its card.");
			txtHelp.setVisible(true);
			collectCards(false);
		}
		
    }
	
	/**
	 * Collect logic for if the computer or player wins by having a higher flipped card. Called from collectHandle
	 * @param playerWin boolean
	 */
	private void collectCards(boolean playerWin)
	{
		if (playerWin) //If true the player won so we must add the computer's card to the bottom of the player's deck along with the player's flipped card -EMN 03-21-2020
		{
			player.add(lbld.getText()); //Adding the computer's flipped card to the bottom of the deck -EMN 03-21-2020
			player.add(lblp.getText()); //Adding the player's flipped card -EMN 03-21-2020
			player.remove(0); //Removing the top card -EMN 03-21-2020
			computer.remove(0); //Removing the top card -EMN 03-21-2020
			
		}
		else
		{
			computer.add(lblp.getText()); //Adding the player's flipped card to the bottom of the deck -EMN 03-21-2020
			computer.add(lbld.getText()); //Adding the computer's flipped card to the bottom of the deck -EMN 03-21-2020
			computer.remove(0); //Removing the top card -EMN 03-21-2020
			player.remove(0); //Removing the top card -EMN 03-21-2020
		}
		
		//Resetting the labels for the flipped cards for the next round -EMN 03-21-2020
		lbld.setText("");
		lblp.setText("");
		
		//Making the flipped cards invisible for the next round -EMN 03-21-2020
		pflip.setVisible(false);
		dflip.setVisible(false);
		
		//Updating the labels that tell us how many cards are in each deck -EMN 03-21-2020
		lblpDeck.setText(War.getDeckSize(player));
		lbldDeck.setText(War.getDeckSize(computer));
		
		//To-Do add logic that checks if the player's deck size is 52 or if the computer deck size is 52. If the player's deck size is 52 (You can either use Integer.parseInt(lblpDeck.getText()) or the player.size()) method to get the deck size.
		//Hide btnFlip and btnCollect using the setVisible(false) method then make btnPlay visible
		//You can display the you win the game message in the txtHelp label using the txtHelp or you can create a different screen
		//EMN 03-21-2020
		
	}
	
	/**
	 *  Collect logic for if the computer or player wins by having a higher card in war. Called from collectWarHandle
	 * @param playerWin boolean
	 */
	private void collectWarCards(boolean playerWin)
	{
		if (playerWin) //Player wins -EMN 03-21-2020
		{
			//Collecting the first pair of flipped cards (These are the cards that made us start the war logic -EMN 03-21-2020
			player.add(ogPlayer);
			player.add(ogCom);
			
			//Collecting the second pair of flipped cards -EMN 03-21-2020
			player.add(lbld.getText());
			player.add(lblp.getText());
			
			//Collecting all the war cards(face down) -EMN 03-21-2020
			player.add(lblpw1.getText());
			player.add(lblpw2.getText());
			player.add(lblpw3.getText());
			player.add(lbldw1.getText());
			player.add(lbldw2.getText());
			player.add(lbldw3.getText());
			
			//Removing the cards that we got from the top of the decks because we added them to the bottom of the deck alread -EMN 03-21-2020
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			
		}
		else
		{
			//Collecting the first pair of flipped cards (These are the cards that made us start the war logic -EMN 03-21-2020
			computer.add(ogPlayer);
			computer.add(ogCom);
			
			//Collecting the second pair of flipped cards -EMN 03-21-2020
			computer.add(lbld.getText());
			computer.add(lblp.getText());
			
			//Collecting all the war cards(face down) -EMN 03-21-2020
			computer.add(lblpw1.getText());
			computer.add(lblpw2.getText());
			computer.add(lblpw3.getText());
			computer.add(lbldw1.getText());
			computer.add(lbldw2.getText());
			computer.add(lbldw3.getText());
			
			//Removing the cards that we got from the top of the decks because we added them to the bottom of the deck alread -EMN 03-21-2020
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
			player.remove(0);
			computer.remove(0);
		}
		
		//Resetting all the cards for the next round -EMN 03-21-2020
		lbld.setText("");
		lblp.setText("");
		lblpw1.setText("");
		lblpw2.setText("");
		lblpw3.setText("");
		lbldw1.setText("");
		lbldw2.setText("");
		lbldw3.setText("");
		
		//Making all the cards invisible for the next round -EMN 03-21-2020
		pflip.setVisible(false);
		dflip.setVisible(false);
		pw1.setVisible(false);
		pw2.setVisible(false);
		pw3.setVisible(false);
		dw1.setVisible(false);
		dw2.setVisible(false);
		dw3.setVisible(false);
		
		//Updating the labels that tell us how many cards are in each deck -EMN 03-21-2020
		lblpDeck.setText(War.getDeckSize(player));
		lbldDeck.setText(War.getDeckSize(computer));
		
		//Making the normal buttons visible again and making the war buttons invisible
		btnFlip.setVisible(true);
		btnWar.setVisible(false);
		btnCollect.setVisible(true);
		btnCollectWar.setVisible(false);
		
		//To-Do add logic that checks if the player's deck size is 52 or if the computer deck size is 52. If the player's deck size is 52 (You can either use Integer.parseInt(lblpDeck.getText()) or the player.size()) method to get the deck size.
		//Hide btnFlip and btnCollect using the setVisible(false) method then make btnPlay visible
		//You can display the you win the game message in the txtHelp label using the txtHelp or you can create a different screen
		//EMN 03-21-2020
		
	}
	/**
	 * This is the event handler for txtHelp.
	 * @param event
	 */
	@FXML
	private void helpHandle(ActionEvent event)
    {
		String helpMsg="Let's play War! War is a game where you must control all 52 cards in the deck. In oder to gain the oppnent's deck you must flip a card higher than them by pressing the \"Flip\" button, then press the \"Collect\" button to start the next round. If you both flip a card that is equal in value then three cards from each of the decks will be put face down and then a card will be flipped to determine who wins all eight cards.";
		
		if(txtHelp.isVisible() && !txtHelp.getText().equals(helpMsg)) //If the label is visible and has information other than helpMsg we are going to display helpMsg -EMN 03-21-2020
		{
			txtHelp.setText(helpMsg);
			txtHelp.setVisible(true);
		}
		else if (txtHelp.isVisible() && txtHelp.getText().equals(helpMsg)) //If the label is visible and it has the helpMsg then we are closing the message -EMN 03-21-2020
		{	txtHelp.setText("");
			txtHelp.setVisible(false);
			
		}
		else //Displaying the label with the help message -EMN 03-21-2020
		{
			txtHelp.setText(helpMsg);
			txtHelp.setVisible(true);
		}
    }
	
	/**
	 * Event handler for the Return to Menu button 
	 * @param event
	 */
	@FXML
	private void returnHandle(ActionEvent event)
    {
		//Changing the root so that we can display the main screen -EMN 03-21-2020
		Main.url=Main.class.getResource("/fxml/titleScreen.fxml");
		Main.loader.setLocation(Main.url);	
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("/fxml/titleScreen.fxml")));
			Main.root=(AnchorPane)Main.loader.load();
		      
			Main.stage.setScene(Main.scene);
			Main.stage.setTitle("Hit Me or Hit Them"); //Changing the title of the primaryStage to better fit the purpose of the application
			Main.stage.show();
		}
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Connecting to the FXML

    }
	
}
