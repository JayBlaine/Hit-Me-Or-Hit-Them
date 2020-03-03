package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	public static AnchorPane root = new AnchorPane();
	public static FXMLLoader loader = new FXMLLoader();
	public static Scene scene = new Scene(root);
	public static java.net.URL url;
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			url=Main.class.getResource("titleScreen.fxml");

			loader.setLocation(url);	
	        scene.setRoot(FXMLLoader.load(getClass().getResource("titleScreen.fxml")));//Connecting to the FXML
	        root=(AnchorPane)loader.load();
	      
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hit me or Hit Them"); //Changing the title of the primaryStage to better fit the purpose of the application
			primaryStage.show();
		} 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
		
		ArrayList <String> deck= Card.getDeck();
		
		Card.displayCards(deck);
	
	}
}
