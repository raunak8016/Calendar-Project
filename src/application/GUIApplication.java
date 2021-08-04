package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
  
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * 
 * @author raunak
 *
 */

public class GUIApplication extends Application {
	
	private void startView() {
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
	 * changes the view to EditPollView and PollVisualizationView
	 * both views are tabs and can be switched
	 * by clicking each tab 
	 */
	void pollView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		polls = Factory.getInstance().createEmptyPolls();

		try {
			loader = new FXMLLoader();
			Tab editView = new Tab("Edit", loader.load(new FileInputStream("src/views/EditPollView.fxml")));
			EditPollController editPollController = loader.getController();
			editPollController.setPolls(polls);
			editPollController.refresh();
			loader = new FXMLLoader();
			Tab visualizeView = new Tab("Visualize", loader.load(new FileInputStream("src/views/VisualizePollView.fxml")));
			VisualizePollController visualizePollController = loader.getController();
			visualizePollController.setPolls(polls);
			TabPane root = new TabPane(editView, visualizeView);
			scene = new Scene(root, 800,500);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
		setupView();
		
	}
	/**
	 * launches the poll tracker application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
