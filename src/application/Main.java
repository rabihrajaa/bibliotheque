package application;
	

import javafx.scene.layout.BorderPane;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application  {
	
	private double xOffset =0 ;
	private double yOffset =0 ;
	

	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
		
		
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
			primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
			
			root.setOnMousePressed(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();
				
					
				}
				
			});
			
			
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					primaryStage.setX(event.getScreenX() - xOffset);
					primaryStage.setX(event.getScreenX() - xOffset);
					
					
				}
				
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
			  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
