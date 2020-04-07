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
import javafx.scene.shape.Rectangle;

/**
 * @author oep957
 *
 */
public class blackJackController 
{
	@FXML
	private Label lblGameOver;
	@FXML
	private Label lblDeck;
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
	Computer cpu = new Computer(diffInt);
	
	ArrayList<String> startingDeck = Card.getDeck();
	ArrayList<String> player = new ArrayList<String>();
	ArrayList<String> computer = new ArrayList<String>();
	
	Stack<String> centerPile = new Stack<String>();
	
	private double startTime;
	private double startSlap;
	private double actualSlap;
	
	private int stackCount = 0;
	private int playerDeckSize = 26;
	private int cpuDeckSize = 26;
	//TODO: FOR CENTER STACK DISPLAY
	
	private boolean isSlappable = false;
	//Add round mechanic?
	@FXML
    private void initialize()
    {
		//Testing computer class
		startTime = System.currentTimeMillis();
		
		System.out.println(startTime);
		//^Testing^
		
		Card.shuffleDeck(startingDeck);
		player = Card.dealCards(startingDeck, 26);
		computer = Card.dealCards(startingDeck, 26);
		
		//Maybe add number of cards left??
		
    }
	
	@FXML
	private void changeDifficulty(ActionEvent event)
	{
		//Changes difficulty based on what's already shown
		//diffInt purely for computer use.
		switch (diffInt) {
			case 1:
				diffInt = 2;
				lblDiff.setText("Medium");
				break;
			case 2:
				diffInt = 3;
				lblDiff.setText("Hard");
				break;
			case 3:
				diffInt = 1;
				lblDiff.setText("Easy");
				break;
			
		}
		cpu.setDifficulty(diffInt);
	}
	@FXML
	private void slapAction(ActionEvent event)
    {
		System.out.println("hit");
		//String test = centerPile.peek();
		//May not need ^^
		if(isSlappable)
		{
			actualSlap = System.currentTimeMillis();
			
			if(actualSlap - startSlap < cpu.getDifficulty() * 1000)
			{
				while(!centerPile.isEmpty())
				{
					String szTemp = centerPile.pop();
					player.add(szTemp);
				}
				lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));
				playerDeckSize += stackCount;
				
				lblDeck.setText("You slapped the jack!");
				stackCount = 0;
				lblStackSize.setText(Integer.toString(stackCount));
				//Player gets the cards, beat cpu.
			}
			//response time vs computer?
			else
			{
				while(!centerPile.isEmpty())
				{
					String szTemp = centerPile.pop();
					computer.add(szTemp);
				}
				lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));
				cpuDeckSize += stackCount;
				
				lblDeck.setText("Your opponenet beat you!");
				stackCount = 0;
				lblStackSize.setText(Integer.toString(stackCount));
				//Computer wins, gets the cards in stack to his deck.
			}
		}
		else 
		{
			while(!centerPile.isEmpty())
			{
				String szTemp = centerPile.pop();
				computer.add(szTemp);
			}
			lblCpuDeck.setText(Integer.toString(cpuDeckSize + stackCount));
			cpuDeckSize += stackCount;
			
			lblDeck.setText("That wasn't a jack!");
			stackCount = 0;
			lblStackSize.setText(Integer.toString(stackCount));
			//NOT A JACK
			
			
		}
		//Convert to label
		
    }
	
	@FXML
	private void flipAction(ActionEvent event)
    {
		System.out.println("hold hit");
		
		if(player.isEmpty() || computer.isEmpty())
		{
			lblDiff.setVisible(false);
			lblStackSize.setVisible(false);
			lblPlayerDeck.setVisible(false);
			lblCpuDeck.setVisible(false);
			lblDeck.setVisible(false);
			txtHelp.setVisible(false);
			btnDiff.setVisible(false);
			btnFlip.setVisible(false);
			btnSlap.setVisible(false);
			btnHelp.setVisible(false);
			rect1.setVisible(false);
			rect2.setVisible(false);
			rect3.setVisible(false);
			if(player.isEmpty())
				lblGameOver.setText("Computer Wins!");
			else
				lblGameOver.setText("You Win!");
		}
		//Convert to label, implement computer actions/comparison between
		//player and cpu.
		centerPile.push(player.get(0));
		player.remove(0);
		
		lblDeck.setText(centerPile.peek());
		
		playerDeckSize--;
		lblPlayerDeck.setText(Integer.toString(playerDeckSize));
		
		stackCount++;
		lblStackSize.setText(Integer.toString(stackCount));
		//Display CENTERPILE
		btnFlip.disarm();
		//TODO: NOT WORKING^^^
		
		//TODO: NOT JACK, SHOULD BE JACK WITH SOME STUFF
		if(centerPile.peek().equals("Jack\u2660") 
				|| centerPile.peek().equals("Jack\u2663")
				|| centerPile.peek().equals("Jack\u2665")
				|| centerPile.peek().equals("Jack\u2666")) 
		{
			startSlap = System.currentTimeMillis();
			isSlappable = true;
		}
		else
			isSlappable = false;

		
			btnFlip.disarm();
			//TODO: SLEEP NOT WORKING TO DISARM BUTTON, ONLY DELAYS CLICK
		computerTurn();
    }
	
	private void computerTurn()
	{
		//MAYBE ADD LBL SAYING IT's COMPUTER TURN
		centerPile.push(computer.get(0));
		computer.remove(0);
		
		lblDeck.setText(centerPile.peek());
		
		cpuDeckSize--;
		lblCpuDeck.setText(Integer.toString(cpuDeckSize));
		
		stackCount++;
		lblStackSize.setText(Integer.toString(stackCount));
		//Display CENTERPILE
		
		if(centerPile.peek().equals("Jack\u2660") 
				|| centerPile.peek().equals("Jack\u2663")
				|| centerPile.peek().equals("Jack\u2665")
				|| centerPile.peek().equals("Jack\u2666"))
		{
			startSlap = System.currentTimeMillis();
			isSlappable = true;
		}
		else
		{
			isSlappable = false;
			
			if(Math.random() > 0.9)
			{
				while(!centerPile.isEmpty())
				{
					String szTemp = centerPile.pop();
					player.add(szTemp);
				}
				playerDeckSize += stackCount;
				lblPlayerDeck.setText(Integer.toString(playerDeckSize + stackCount));
				
				lblDeck.setText("Your opponent slapped the wrong card!");
				stackCount = 0;
				lblStackSize.setText(Integer.toString(stackCount));
				//Computer slaps when not a jack, player gets cards.
			}
			
		}
		
		
		btnFlip.arm();
	}
	
	@FXML
	private void returnAction(ActionEvent event)
    {
		Main.url=Main.class.getResource("titleScreen.fxml");
		Main.loader.setLocation(Main.url);	
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("titleScreen.fxml")));
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
	
	@FXML
	private void helpAction(ActionEvent event)
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
