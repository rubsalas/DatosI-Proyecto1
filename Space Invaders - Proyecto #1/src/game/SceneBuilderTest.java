package game;

//import java.io.IOException;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
//import javafx.scene.layout.*;
//import javafx.scene.control.*;
//import javafx.geometry.*;


public class SceneBuilderTest{ //extends Application{
	
//	public static void main(String[] args){
//		launch(args);
//	}
//
//	public void start(Stage primaryStage) throws IOException{
//		Parent root = FXMLLoader.load(getClass().getResource("SpaceInvadersMain.fxml"));
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("SceneBuilderTest");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//	
//}



	public static void main(String[] args){
		
	
		
		Thread t1 = new Thread( new Runnable(){
			
			public void run(){
				int i = 0;
				while(i!=30){
				System.out.println(i++);
				
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		t1.start();
	}
	
}