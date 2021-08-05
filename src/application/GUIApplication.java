package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Calendar;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author raunak
 *
 */

public class GUIApplication extends Application {
	private Stage primaryStage;
	
	public void startView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/views/StartView.fxml"));
			StartViewController setupController = loader.getController();
			setupController.linkWithApplication(this);
			scene = new Scene(setupView, 700, 700);
			primaryStage.setScene(scene);
			primaryStage.show();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * changes the view to MainView.fxml
	 * 	 */
	public void mainView(int year, int month) {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {

			BorderPane root = loader.load(new FileInputStream("src/views/MainView.fxml"));
			MainViewController mainViewController = loader.getController();
			mainViewController.linkWithApplication(this);
			mainViewController.setCalendar(year, month);
			scene = new Scene(root,700,500);
			primaryStage.setScene(scene);
			primaryStage.show();
			

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void calendarView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/views/CalendarView.fxml"));
			scene = new Scene(setupView, 200, 200);
			Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Starts the application by throwing the SetupView and
	 * its controller to the user entering and/or starting
	 * the application.
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		startView();
		
	}
	/**
	 * launches the poll tracker application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
