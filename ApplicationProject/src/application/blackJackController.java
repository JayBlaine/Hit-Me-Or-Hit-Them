/**
 * 
 */
package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	private Rectangle p1;
	@FXML
	private Rectangle p2;
	@FXML
	private Rectangle p3;
	@FXML
	private Rectangle p4;
	@FXML
	private Rectangle p5;
	@FXML
	private Rectangle d1;
	@FXML
	private Rectangle d2;
	@FXML
	private Rectangle d3;
	@FXML
	private Rectangle d4;
	@FXML
	private Rectangle d5;
	@FXML
	private Label lblp1;
	@FXML
	private Label lblp2;
	@FXML
	private Label lblp3;
	@FXML
	private Label lblp4;
	@FXML
	private Label lblp5;
	@FXML
	private Label lbld1;
	@FXML
	private Label lbld2;
	@FXML
	private Label lbld3;
	@FXML
	private Label lbld4;
	@FXML
	private Label lbld5;
	@FXML
	private Label lblDeck;
	@FXML
	private Label txtHelp;
	
	//Add round mechanic?
	//Maybe add betting??
	@FXML
    private void initialize()
    {
		
    }
	
	@FXML
	private void changeDifficulty(ActionEvent event)
	{
		
	}
	@FXML
	private void slapAction(ActionEvent event)
    {
		System.out.println("hit");
		//Convert to label, implement randomness into deck shuffling
		
    }
	
	@FXML
	private void flipAction(ActionEvent event)
    {
		System.out.println("hold hit");
		//Convert to label, implement computer actions/comparison between
		//player and cpu.
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
