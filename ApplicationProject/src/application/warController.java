/**
 * 
 */
package application;

import java.io.IOException;

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
public class warController
{
	@FXML
	private Rectangle pflip;
	@FXML
	private Rectangle dflip;
	@FXML
	private Rectangle pw1;
	@FXML
	private Rectangle pw2;
	@FXML
	private Rectangle pw3;
	@FXML
	private Rectangle dw1;
	@FXML
	private Rectangle dw2;
	@FXML
	private Rectangle dw3;
	@FXML
	private Label lblp;
	@FXML
	private Label lbld;
	@FXML
	private Label lblpdeck;
	@FXML
	private Label lbldDeck;
	@FXML
	private Label lblpw1;
	@FXML
	private Label lblpw2;
	@FXML
	private Label lblpw3;
	@FXML
	private Label lbldw1;
	@FXML
	private Label lbldw2;
	@FXML
	private Label lbldw3;
	@FXML
	private Label txtHelp;
	
	@FXML
    private void initialize()
    {
		
    }
	
	@FXML
	private void flipHandle(ActionEvent event)
    {
		System.out.println("flip");
    }
	
	@FXML
	private void collectHandle(ActionEvent event)
    {
		System.out.println("collect");
    }
	
	@FXML
	private void helpHandle(ActionEvent event)
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
	
	@FXML
	private void returnHandle(ActionEvent event)
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
}
