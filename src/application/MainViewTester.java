package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author raunak
 *
 */

public class MainViewTester extends Application{
	/**
	 * Starts the Tester class application for the
	 * MainView.fxml file by loading a new
	 * scene on the Stage instance
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			//loader code to initiate the scene
			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(new FileInputStream("src/views/MainView.fxml"));
			Scene scene = new Scene(root,700,500);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * launches the MainView scene
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
