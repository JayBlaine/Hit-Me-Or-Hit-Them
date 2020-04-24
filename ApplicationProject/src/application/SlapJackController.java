/**
 * 
 */
package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SlapJackController 
{
	@FXML
	private Label lblGameOver;
	@FXML
	private Label lblDeck;
	@FXML
	private Label lblDeck2;
	@FXML
	private Label txtHelp;
	@FXML
	private Label lblDiff;
	@FXML
	private Label lblPlayerDeck;
	@FXML
	private Label lblCpuDeck;
	@FXML
	private Label lblStackSize;
	@FXML
	private Label lblMsg;
	@FXML
	private Button btnFlip;
	@FXML
	private Button btnSlap;
	@FXML
	private Button btnDiff;
	@FXML
	private Button btnHelp;
	@FXML
	private Button btnReturn;
	@FXML
	private Rectangle rect1;
	@FXML
	private Rectangle rect2;
	@FXML
	private Rectangle rect3;
	
	private int diffInt = 1;
	
	@SuppressWarnings("unused")
	private double startTime;											//instance variable
	private double startSlap;											//instance variable
	private double actualSlap;											//instance variable
	
	private int stackCount = 0;											//instantiating
	private int playerDeckSize = 26;									//instantiating
	private int cpuDeckSize = 26;										//instantiating
					
	private boolean isSlappable = false;								//instantiating
	private boolean playerTurn = true;									//instantiating
	
	private Computer cpu = new Computer(diffInt);						//instantiating
	private ArrayList<String> startingDeck = Card.getDeck();			//instantiating
	private ArrayList<String> player = new ArrayList<String>();			//instantiating
	private ArrayList<String> computer = new ArrayList<String>();		//instantiating
	private Stack<String> centerPile = new Stack<String>();				//instantiating
	
	
	@FXML
    private void initialize()											//this runs at the beginning "initializing" everything 
    {
		
		Card.shuffleDeck(startingDeck);									//shuffle deck
		player = Card.dealCards(startingDeck, 26);						//give player deck 26 cards
		computer = Card.dealCards(startingDeck, 26);					//give CPU deck 26 cards
		
    }
	
	@FXML
	private void changeDifficulty(ActionEvent event)					//method handles the change of difficulty button
	{
		switch (diffInt) {												//switch statement if difficulty is easy medium or hard set it to so 
			case 1:
				diffInt = 2;											//set difficulty
				lblDiff.setText("Medium");								//set text
				break;
			case 2:
				diffInt = 3;											//set difficulty
				lblDiff.setText("Hard");								//set text
				break;
			case 3:
				diffInt = 1;											//set difficulty
				lblDiff.setText("Easy");								//set text
				break;
			
		}
		cpu.setDifficulty(diffInt);
	}
	@FXML
	private void slapAction(ActionEvent event)							//this method takes cares of the slapping action
    {
		System.out.println("hit");										//system out print text

		if(isSlappable)													//if slappable is true
		{	
			actualSlap = System.currentTimeMillis();					//then get the time of how long it took to slap and set it to actual slap
			
			if(actualSlap - startSlap < cpu.getDifficulty() * 1000)		//if the time of slap is smaller than the CPU difficulty; if Player gets the cards, beat CPU.
			{
				while(!centerPile.isEmpty())							//while the center pile is empty
				{
					String szTemp = centerPile.pop();					//set a the center pile card to temporary string
					computer.add(szTemp);								//add the card to the computer deck 
				}
				lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));//set the player deck label to current size
				playerDeckSize += stackCount;							//set the player deck to current size
				
				stackCount = 0;											//initializing - resetting the stack count to be zero				
				lblStackSize.setText(Integer.toString(stackCount));		//setting label to the current stack size
				lblMsg.setText("You slapped the jack!");				//setting label text
				lblDeck.setText("");
				lblDeck2.setText("");
																			
			}
			else														//Computer wins, gets the cards in stack to his deck.
			{
				while(!centerPile.isEmpty())							//while the center pile is empty
				{
					String szTemp = centerPile.pop();					//set a the center pile card to temporary string
					computer.add(szTemp);								//add the card to the computer deck 
				}
				lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));//set the CPU deck label to the current size
				cpuDeckSize += stackCount;									   //set the CPU deck to the current size
				
				stackCount = 0;											//initializing - resetting the stack count to be zero
				lblStackSize.setText(Integer.toString(stackCount));		//setting label to current stack size
				lblMsg.setText("Your opponenet beat you!");			//setting label text
				lblDeck.setText("");
				lblDeck2.setText("");
			}
		}
		else 
		{
			while(!centerPile.isEmpty())							//while the center pile is empty
			{
				String szTemp = centerPile.pop();					//set a the center pile card to temporary string
				computer.add(szTemp);								//add the card to the computer deck 
			}
			lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));//set the CPU deck label to the current size
			cpuDeckSize += stackCount;									   //set the CPU deck to the current size
			
			stackCount = 0;											//initializing - resetting the stack count to be zero
			lblStackSize.setText(Integer.toString(stackCount));		//setting label to current stack size
			lblMsg.setText("That wasn't a jack!");					//setting label text
			lblDeck.setText("");
			lblDeck2.setText("");
		}
		
    }
	
	@FXML
	private void flipAction(ActionEvent event) throws InterruptedException	//this method takes care of the flip action
    {
		System.out.println("hold hit");									//systemout print text
		if(playerTurn)													//if player turn is true  
		{
			playerTurn = false;											//set the player turn to false

			rect1.setFill(Color.GREEN);									//change the color of dekcs
			rect3.setFill(Color.RED);									//change color of dekcs

		
			if(player.isEmpty() || computer.isEmpty())					//if either Player or CPU's deck is empty then do---
			{
				lblDiff.setVisible(false);								//set visibility
				lblStackSize.setVisible(false);							//set visibility
				lblPlayerDeck.setVisible(false);						//set visibility
				lblCpuDeck.setVisible(false);							//set visibility
				lblDeck.setVisible(false);								//set visibility
				lblDeck2.setVisible(false);
				txtHelp.setVisible(false);								//set visibility
				btnDiff.setVisible(false);								//set visibility
				btnFlip.setVisible(false);								//set visibility
				btnSlap.setVisible(false);								//set visibility
				btnHelp.setVisible(false);								//set visibility
				rect1.setVisible(false);								//set visibility
				rect2.setVisible(false);								//set visibility		
				rect3.setVisible(false);								//set visibility
				if(player.isEmpty())									//if player deck is empty then the computer wins if it is not empty then the computer wins
					lblGameOver.setText("Computer Wins!");				//set text
				else
					lblGameOver.setText("You Win!");					//set text
			}
			
			if(!centerPile.isEmpty() 									//if center pile is not empty and equals a jack then do---
					&& (centerPile.peek().equals("Jack\u2660") 
					|| centerPile.peek().equals("Jack\u2663")
					|| centerPile.peek().equals("Jack\u2665")
					|| centerPile.peek().equals("Jack\u2666"))) 
			{	
				while(!centerPile.isEmpty())							//while center pile is not empty then
				{
					String szTemp = centerPile.pop();					//get the center pile card and store its value in a temporary string variable
					computer.add(szTemp);								//add the card to the computers deck
				}
				lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));//set the computers deck label to be the current deck size
				cpuDeckSize += stackCount;								//add the stackcount to the computers deck size
				
				stackCount = 0;											//initializing - resetting the stack back to zero 
				lblStackSize.setText(Integer.toString(stackCount));		//setting the stack label to the current stack size
				lblMsg.setText("You skipped over a jack!");			//setting the label text 
				lblDeck.setText("");
				lblDeck2.setText("");
				
																		//Player skips over jack.
			}
			
			centerPile.push(player.get(0));								//get card from player deck and display it in the center pile 
			player.remove(0);											//remove card from player deck
			
			lblMsg.setText("");
			lblDeck.setText(centerPile.peek());							//set the deck label to be the card from center pile (display what card )
			lblDeck2.setText(centerPile.peek());
			
			playerDeckSize--;											//decrement the player deck size by one
			lblPlayerDeck.setText(Integer.toString(playerDeckSize));	//set the player deck label to the deck size
			
			stackCount++;												//increment the stack count by one
			lblStackSize.setText(Integer.toString(stackCount));			//Display CENTERPILE and set the text to the current stack size
			
			
			if(centerPile.peek().equals("Jack\u2660") 					//if center pile is equal to a Jack then do---
					|| centerPile.peek().equals("Jack\u2663")
					|| centerPile.peek().equals("Jack\u2665")
					|| centerPile.peek().equals("Jack\u2666")) 
			{
				startSlap = System.currentTimeMillis();					//get the time and set it equal to startSlap
				isSlappable = true;										//set slappable to true
			}
			else														//if the card is not a jack then
				isSlappable = false;									//set slappable to false

			}
			
			else													
			{
				computerTurn();											//call the computer turn method -- see line 266				
				playerTurn = true;										//setting player turn to true
				rect3.setFill(Color.GREEN);								//Change color of decks
				rect1.setFill(Color.RED);								//Change color of decks
				
			}
	    }
		
		private void computerTurn() throws InterruptedException			//method that handles the computers turn 
		{
		if(!centerPile.isEmpty() 									//if the centerpile is not empty and the card on top is a Jack then do ---- 
				&& (centerPile.peek().equals("Jack\u2660") 
				|| centerPile.peek().equals("Jack\u2663")
				|| centerPile.peek().equals("Jack\u2665")
				|| centerPile.peek().equals("Jack\u2666"))) 
		{
			while(!centerPile.isEmpty())							//while the center pile is not empty do-----
			{
				String szTemp = centerPile.pop();					//temporary string to get card from center deck 
				computer.add(szTemp);								//adding card to computer 
			}
			lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));//setting text to current computers deck size 
			cpuDeckSize += stackCount;								//adding stack count to computer deck size
			
			stackCount = 0;											//insitializing 
			lblStackSize.setText(Integer.toString(stackCount));		//set text of the stack size to be current stack count
			lblMsg.setText("You skipped over a jack!");			    //set text
			lblDeck.setText("");
			lblDeck2.setText("");
																	//Player skips over jack.
		}
		
		centerPile.push(computer.get(0));							//putting the card from computer deck to center pile deck 
		computer.remove(0);											//removing card from computer deck (string)
		
		lblMsg.setText("");
		lblDeck.setText(centerPile.peek());							//set the deck label to its current card
		lblDeck2.setText(centerPile.peek());
		
		cpuDeckSize--;												//removing one from deck size
		lblCpuDeck.setText(Integer.toString(cpuDeckSize));			//setting the cpu deck size label to its current size
		
		stackCount++;												//adding to Stack count
		lblStackSize.setText(Integer.toString(stackCount));			//Display CENTERPILE


		if(centerPile.peek().equals("Jack\u2660") 		   			//if the center equals a Jack then 
				|| centerPile.peek().equals("Jack\u2663")
				|| centerPile.peek().equals("Jack\u2665")
				|| centerPile.peek().equals("Jack\u2666"))
		{
			startSlap = System.currentTimeMillis();		  			//set the time to startSlap
			isSlappable = true;										//set slappable to true 
		}
		else
		{
			isSlappable = false;									//set slappable to false 
			
			switch(diffInt) 										//switch statement for the difficutly
			{
			case 1:
				if(Math.random() > 0.9)								//if random number is greater than 0.9				
				{
					while(!centerPile.isEmpty())					//while center pile is empty
					{
						String szTemp = centerPile.pop();			//create temporary string to get card from center pile
						player.add(szTemp);							//add card to player deck
					}
					playerDeckSize += stackCount;					//add stack count to player deck size
					lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));//set label text to current size 
					
					stackCount = 0;									//reset stack count back to zero
					lblStackSize.setText(Integer.toString(stackCount));//set the stack size to stack count
					lblMsg.setText("Your opponent slapped the wrong card!");
					lblDeck.setText("");
					lblDeck2.setText("");
																	//Computer slaps when not a jack, player gets cards.
				}
				break;
			case 2:
				if(Math.random() > 0.95)							//if random number is bigger than 0.95
				{
					while(!centerPile.isEmpty())					//while center pile is empty
					{
						String szTemp = centerPile.pop();			//create temporary string to get card from center pile
						player.add(szTemp);							//add card to player
					}
					playerDeckSize += stackCount;					//add stack count to player deck size
					lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));//set label player deck to the current size
					
					stackCount = 0;									//reset the stack count to be zero
					lblStackSize.setText(Integer.toString(stackCount));//set text label to the stack count
					lblMsg.setText("Your opponent slapped the wrong card!");
					lblDeck.setText("");
					lblDeck2.setText("");
																	//Computer slaps when not a jack, player gets cards.
				}
				break;
			case 3:
				if(Math.random() > 0.97)							//if random number is bigger than 0.97
				{
					while(!centerPile.isEmpty())					//if the centerpile is not empty 
					{
						String szTemp = centerPile.pop();			//create temporary string to get card from center pile
						player.add(szTemp);							//add card to player
					}
					playerDeckSize += stackCount;					//add stack count to player deck size
					lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));//set label player deck to the current size 
					
					stackCount = 0;									//reset the stack count to be zero 
					lblStackSize.setText(Integer.toString(stackCount));////set text label to the stack count 
					lblMsg.setText("Your opponent slapped the wrong card!");
					lblDeck.setText("");
					lblDeck2.setText("");
																	//Computer slaps when not a jack, player gets cards.
				}
				break;
			}
			
		}
		
	}
	
	@FXML
	private void returnAction(ActionEvent event)					//method that takes the user back to the title page after return button is clicked
    {
		Main.url=Main.class.getResource("/fxml/titleScreen.fxml");		//instantiating   
		Main.loader.setLocation(Main.url);							//loading fxml
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("/fxml/titleScreen.fxml")));//loading fxml
			Main.root=(AnchorPane)Main.loader.load();				//loading the pane to the stage
		      
			Main.stage.setScene(Main.scene);						//adding scene to stage
			Main.stage.setTitle("Hit Me or Hit Them"); 				//Changing the title of the primaryStage to better fit the purpose of the application
			Main.stage.show();
		}
        catch (IOException e) 
        {
			e.printStackTrace();
		}															//Connecting to the FXML
    }
	
	@FXML
	private void helpAction(ActionEvent event)						//method that sets the help button to visible or invisible
	{
		if(txtHelp.isVisible())
		{
			txtHelp.setVisible(false);
		}
		else
		{
			txtHelp.setVisible(true);
		}
	}
}
