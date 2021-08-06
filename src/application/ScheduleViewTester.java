package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Sidd
 *
 */
public class ScheduleViewTester extends Application {
//	private Stage primaryStage = new Stage();
	
//	public void eventView() {
//		FXMLLoader loader= new FXMLLoader();
//		Scene scene;
//		try {
//			Parent setupView = (Parent) loader.load(new FileInputStream("src/views/EventView.fxml"));
//			scene = new Scene(setupView, 400, 400);
//			Stage stage = new Stage();
//			stage.setTitle("View Event");
//			stage.show();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/views/ScheduleView.fxml"));
			Scene scene = new Scene(root, 500, 500);
			
//			this.primaryStage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
