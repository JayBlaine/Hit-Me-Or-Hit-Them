package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class SlapJackModel 
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
	private static Label lblDiff;
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
	
	
	
	public static int handleSlapDifficulty(int diffInt)
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
		return diffInt;
	}
	
	public static void handleSlapSlap()
	{
		
	}
	
	public static void handleSlapFlip()
	{
		
	}
	//computer turn BELOW
	
	public static void handleHelp()
	{
		
	}
	

}
