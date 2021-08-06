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
	
	/**
	 * The starting view that the user gets when they
	 * haven't created a Calendar. This ensures
	 * that the user can only navigate the app
	 * if they have a Calendar for which they can
	 * schedule events in.
	 */
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
	 * Changes the view to the MainView.fxml, and
	 * sets a new Scene to open as a window for
	 * the MainView file and controller class.
	 */
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
	
	/**
	 * Changes the view to the CalendarView.fxml,
	 * and sets a new Scene to open as a window
	 * for the CalendarView file and controller
	 * class.
	 * 
	 * @param passOn the Calendar object value
	 * to display the data or representation of.
	 */
	public void calendarView(Calendar passOn) {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			BorderPane root = loader.load(new FileInputStream("src/views/CalendarView.fxml"));
			CalendarViewController calViewController = loader.getController();
			calViewController.Initialize(passOn);
			scene = new Scene(root, 200, 200);
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
	 * Adds the AddEvetView.fxml, and switches to a window
	 * which allows the user to add and event to whichever
	 * Schedule they select.
	 */
	public void addEventView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/views/AddEventView.fxml"));
			scene = new Scene(setupView, 500, 500);
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
	 * Adds the ScheduleView, which allows the user to
	 * view the Event objects booked within a given
	 * Schedule object.
	 */
	public void scheduleView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("src/views/ScheduleView.fxml"));
			scene = new Scene(setupView, 500, 500);
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
