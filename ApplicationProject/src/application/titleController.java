/**
 * 
 */
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * @author oep957
 *
 */
public class titleController 
{
	
	@FXML
	private void handle(ActionEvent event)
    {
		Main.url=Main.class.getResource("SlapJackScreen.fxml");
		Main.loader.setLocation(Main.url);	
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("SlapJackScreen.fxml")));
			Main.root=(AnchorPane)Main.loader.load();
		      
			Main.stage.setScene(Main.scene);
			Main.stage.setTitle("Slap Jack"); //Changing the title of the primaryStage to better fit the purpose of the application
			Main.stage.show();
		
			System.out.println("Slap Jack");
		}
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Connecting to the FXML
		 
    }
	
	@FXML
	private void handleWar(ActionEvent event)
    {
		
		Main.url=Main.class.getResource("warScreen.fxml");
		Main.loader.setLocation(Main.url);	
        try {
			Main.scene.setRoot(FXMLLoader.load(getClass().getResource("warScreen.fxml")));
			Main.root=(AnchorPane)Main.loader.load();
		      
			Main.stage.setScene(Main.scene);
			Main.stage.setTitle("War"); //Changing the title of the primaryStage to better fit the purpose of the application
			Main.stage.show();
		
			System.out.println("war");
		}
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Connecting to the FXML
		 
		 
    }
	
	
}
