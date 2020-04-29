/**
 * @author Joseph D'Amico fep771
 * PokerController.java creates a functional GUI and acts as the controller to Poker.java's model and Poker.fxml's view.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Poker;
import backend.Card;

public class PokerController {
	
	@FXML
    private Button play, deal, helpButton; //  B U T T O N (play the game, start the game, learn the rules)
    
    @FXML
    private Button buttonHeart1, buttonHeart2, buttonHeart3, buttonHeart4, buttonHeart5; // suit view
    
    @FXML
    private Button buttonDiamond1, buttonDiamond2, buttonDiamond3, buttonDiamond4, buttonDiamond5; // suit view
    
    @FXML
    private Button buttonSpade1, buttonSpade2, buttonSpade3, buttonSpade4, buttonSpade5; //suit view
    
    @FXML
    private Button buttonClub1, buttonClub2, buttonClub3, buttonClub4, buttonClub5; //suit view 

    @FXML
    private Label BottomNumber1, BottomNumber2, BottomNumber3, BottomNumber4, BottomNumber5; // number view
    
    @FXML
    private Label TopNumber1, TopNumber2, TopNumber3, TopNumber4, TopNumber5; // number view

    @FXML
    private Rectangle card1, card2, card3, card4, card5; // card view

    @FXML
    private Label statusLabel; //shows a victory or loss message and player/cpu victory conditions
    
	private Stage popupwindow = new Stage(); //helpButton popup
	
	/**
	 * This method handles the play button and makes other objects visible or invisible
	 * @return void
	 */
    @FXML
    void handlePlay(ActionEvent event) { //handles play button
		play.setVisible(false);
		deal.setVisible(true);
		statusLabel.setVisible(false);
    }

    /**
     * Generates a help menu with instructions on how the game is played
     * @return void
     */
    @FXML
    void handleHelpButton(ActionEvent event) { // handles help button
    	popupwindow.setTitle("How to Play");
		Label label= new Label("\tThe player and the CPU are each given 5 cards from the deck. Whoever has the greatest ranked hand wins the game!"
				+ " Hand ranks are listed from greates the least ranked. If both the player and CPU have the same rank, the one with the highest"
				+ "card wins. If they both have an equal highest card, then the game ends in a tie."
				+ "\n\n\t*Straight Flush"
				+ "\n\t*Four of a Kind"
				+ "\n\t*Full House"
				+ "\n\t*Flush"
				+ "\n\t*Straight"
				+ "\n\t*Three of a Kind"
				+ "\n\t*Two Pair"
				+ "\n\t*Pair"
				+ "\n\t*High Card");
		VBox layout= new VBox(10);
		layout.getChildren().add(label);
		label.setContentDisplay(ContentDisplay.TOP);
		label.setAlignment(Pos.CENTER);
		label.setWrapText(true);
		Scene scene= new Scene(layout, 400, 450);
		popupwindow.setResizable(false);
		popupwindow.setScene(scene);
		popupwindow.showAndWait();
    }

    /**
     * Returns the view to the title screen
     * @return void
     */
    @FXML
    void returnAction(ActionEvent event) { // handles return to home screen
    	Main.url=Main.class.getResource("/fxml/titleScreen.fxml");  
		Main.loader.setLocation(Main.url);							
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("/fxml/titleScreen.fxml")));
			Main.root=(AnchorPane)Main.loader.load();				
			Main.stage.setScene(Main.scene);						
			Main.stage.setTitle("Hit Me or Hit Them"); 
			Main.stage.show();
		}
        catch (IOException e) 
        {
			e.printStackTrace();
		}	
    }
    
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>(52);
	private static Deque<Card> playerHand = new LinkedList<Card>();
	private static Deque<Card> cpuHand = new  LinkedList<Card>();
	private static Deque<Card> popHand = new LinkedList<Card>();
   
	/**
	 * Handles the dealing of cards (making of objects visible) and calls dealCards() from Poker.java
	 * @return void
	 */
	@FXML
	public void handleDeal(ActionEvent event) {
		statusLabel.setVisible(true);
		
		for(int j=1; j<14; j++)							//add Cards to deckOfCards
			deckOfCards.add(new Card(j, "Spades"));
		for(int j=1; j<14; j++)
			deckOfCards.add(new Card(j, "Hearts"));
		for(int j=1; j<14; j++)
			deckOfCards.add(new Card(j, "Diamonds"));
		for(int j=1; j<14; j++)
			deckOfCards.add(new Card(j, "Clubs"));
		
		Collections.shuffle(deckOfCards);				//shuffle the deck
		
		for(int i = 0; i<10; i++) 
		{		//split the deck 
			if(i%2 == 0) 
			{								//if i mod 2 = 0
				playerHand.add(deckOfCards.get(i));		//then add card to playerHand
				popHand.add(deckOfCards.get(i));
			}else 
			{										//if i mod 2 does not equal 0
				cpuHand.add(deckOfCards.get(i));		//then add card to computerHand
			}
		}	
		String victory = Poker.dealCards(playerHand, cpuHand); // figure out winning conditions
	
		String[] tokenized = (popHand.getFirst()).toString().split(" "); //tokenize suit and rank
		String rank = tokenized[0];
		String suit = tokenized[1];	
		System.out.print(tokenized[1]);
		if(rank == "1") {
			TopNumber1.setText("A");
			BottomNumber1.setText("A");
		}
		else if(rank == "11") {
			TopNumber1.setText("J");
			BottomNumber1.setText("J");
		}
		else if(rank == "12") {
			TopNumber1.setText("Q");
			BottomNumber1.setText("Q");
		}
		else if(rank == "13") {
			TopNumber1.setText("K");
			BottomNumber1.setText("K");
		}
		else {
			TopNumber1.setText(rank);
			BottomNumber1.setText(rank);
		}
		card1.setVisible(true); // make everything visible for card
		TopNumber1.setVisible(true);
		BottomNumber1.setVisible(true);
		if(suit == "Hearts") {
			buttonHeart1.setVisible(true); // make suit visible
		}
		else if(suit == "Diamonds") {
			buttonDiamond1.setVisible(true); // make suit visible
		}
		else if(suit == "Spades") {
			buttonSpade1.setVisible(true); // make suit visible
		}
		else if(suit == "Clubs") {
			buttonClub1.setVisible(true); // make suit visible
		}
		//card2
		tokenized = (popHand.getFirst()).toString().split(" "); 
		rank = tokenized[0]; 
		suit = tokenized[1];
		if(rank == "1") {
			TopNumber2.setText("A");
			BottomNumber2.setText("A");
		}
		else if(rank == "11") {
			TopNumber2.setText("J");
			BottomNumber2.setText("J");
		}
		else if(rank == "12") {
			TopNumber2.setText("Q");
			BottomNumber2.setText("Q");
		}
		else if(rank == "13") {
			TopNumber2.setText("K");
			BottomNumber2.setText("K");
		}
		else {
			TopNumber2.setText(rank);
			BottomNumber2.setText(rank);
		}
		card2.setVisible(true); 
		TopNumber2.setVisible(true);
		BottomNumber2.setVisible(true);
		if(suit == "Hearts") {
			buttonHeart2.setVisible(true);
		}
		else if(suit == "Diamonds") {
			buttonDiamond2.setVisible(true);
		}
		else if(suit == "Spades") {
			buttonSpade2.setVisible(true);
		}
		else if(suit == "Clubs") {
			buttonClub2.setVisible(true);
		}
	
		popHand.pop();
		//card3
		tokenized = (popHand.getFirst()).toString().split(" ");
		rank = tokenized[0];
		suit = tokenized[1];
		if(rank == "1") {
			TopNumber3.setText("A");
			BottomNumber3.setText("A");
		}
		else if(rank == "11") {
			TopNumber3.setText("J");
			BottomNumber3.setText("J");
		}
		else if(rank == "12") {
			TopNumber3.setText("Q");
			BottomNumber3.setText("Q");
		}
		else if(rank == "13") {
			TopNumber3.setText("K");
			BottomNumber3.setText("K");
		}
		else {
			TopNumber3.setText(rank);
			BottomNumber3.setText(rank);
		}
		card3.setVisible(true);
		TopNumber3.setVisible(true);
		BottomNumber3.setVisible(true);
		if(suit == "Hearts") {
			buttonHeart3.setVisible(true);
		}
		else if(suit == "Diamonds") {
			buttonDiamond3.setVisible(true);
		}
		else if(suit == "Spades") {
			buttonSpade3.setVisible(true);
		}
		else if(suit == "Clubs") {
			buttonClub3.setVisible(true);
		}
		
		
		popHand.pop();
		//card4
		tokenized = (popHand.getFirst()).toString().split(" ");
		rank = tokenized[0];
		suit = tokenized[1];
		if(rank == "1") {
			TopNumber4.setText("A");
			BottomNumber4.setText("A");
		}
		else if(rank == "11") {
			TopNumber4.setText("J");
			BottomNumber4.setText("J");
		}
		else if(rank == "12") {
			TopNumber4.setText("Q");
			BottomNumber4.setText("Q");
		}
		else if(rank == "13") {
			TopNumber4.setText("K");
			BottomNumber4.setText("K");
		}
		else {
			TopNumber4.setText(rank);
			BottomNumber4.setText(rank);
		}
		card4.setVisible(true);
		TopNumber4.setVisible(true);
		BottomNumber4.setVisible(true);
		if(suit == "Hearts") {
			buttonHeart4.setVisible(true);
		}
		else if(suit == "Diamonds") {
			buttonDiamond4.setVisible(true);
		}
		else if(suit == "Spades") {
			buttonSpade4.setVisible(true);
		}
		else if(suit == "Clubs") {
			buttonClub4.setVisible(true);
		}
		
		popHand.pop();
		//card5
		tokenized = (popHand.getFirst()).toString().split(" ");
		rank = tokenized[0];
		suit = tokenized[1];
		if(rank == "1") {
			TopNumber5.setText("A");
			BottomNumber5.setText("A");
		}
		else if(rank == "11") {
			TopNumber5.setText("J");
			BottomNumber5.setText("J");
		}
		else if(rank == "12") {
			TopNumber5.setText("Q");
			BottomNumber5.setText("Q");
		}
		else if(rank == "13") {
			TopNumber5.setText("K");
			BottomNumber5.setText("K");
		}
		else {
			TopNumber5.setText(rank);
			BottomNumber5.setText(rank);
		}
		card5.setVisible(true);
		TopNumber5.setVisible(true);
		BottomNumber5.setVisible(true);
		if(suit == "Hearts") {
			buttonHeart5.setVisible(true);
		}
		else if(suit == "Diamonds") {
			buttonDiamond5.setVisible(true);
		}
		else if(suit == "Spades") {
			buttonSpade5.setVisible(true);
		}
		else if(suit == "Clubs") {
			buttonClub5.setVisible(true);
		}
		
		popHand.pop();
		
		statusLabel.setText(victory);
			
	}
}