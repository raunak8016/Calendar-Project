package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Event;
import models.Schedule;

/**
 * 
 * @author Sidd
 *
 */
public class ScheduleViewController {
	//ArrayList of events
	private ArrayList<Event> schedule;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Event> eventListView;
    
    @FXML
    private Button closeScheduleViewButton;
    
    /**
     * closes Schedule View when Schedule is clicked
     * @param event
     */
    @FXML
    void closeScheduleViewButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) closeScheduleViewButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Shows in depth view of event when
     * viewEventButton is clicked
     * @param event
     */
    @FXML
    void viewEventButtonClicked(ActionEvent event) {
    	int index = eventListView.getSelectionModel().getSelectedIndex();
    	viewEvent(index);
    }
    
    /**
     * Opens up another window for a user to view whichever Event
     * object they have selected in the ListView within the
     * GUI of the ScheduleView Controller.
     * 
     * @param index of the list in which the Event object exists.
     */
    public void viewEvent(int index) {
    	FXMLLoader loader = new FXMLLoader();
		Scene scene;
		try {
			BorderPane root = loader.load(new FileInputStream("src/views/EventView.fxml"));
			EventViewController eventViewController = loader.getController();
			eventViewController.initialize(index);
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
     * Initializes the Controller, and sets the EventView to an
     * ObservableArrayList object, so JavaFX can interact with them.
     */
    @FXML
    void initialize() {
        assert eventListView != null : "fx:id=\"eventListView\" was not injected: check your FXML file 'ScheduleView.fxml'.";

        schedule = AddEventViewController.Schedule;
        eventListView.setItems(FXCollections.observableArrayList(schedule));
    }

}
