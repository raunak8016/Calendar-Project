package application;

import java.net.URL;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Event;

/**
 * 
 * @author Sidd
 *
 */
public class AddEventViewController {
	private Event eventToAdd;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="eventNameField"
    private TextField eventNameField; // Value injected by FXMLLoader

    @FXML // fx:id="eventEndField"
    private TextField eventEndField; // Value injected by FXMLLoader

    @FXML // fx:id="eventStartField"
    private TextField eventStartField; // Value injected by FXMLLoader

    @FXML // fx:id="cancelEventButton"
    private Button cancelEventButton; // Value injected by FXMLLoader

    @FXML // fx:id="eventDateField"
    private TextField eventDateField; // Value injected by FXMLLoader

    @FXML // fx:id="addEventButton"
    private Button addEventButton; // Value injected by FXMLLoader
    
    static ArrayList<Event> Schedule = new ArrayList<Event>(); 

    /**
     * Closes the window if the user decides that they do not
     * want to add another event.
     * 
     * @param event where the user clicks the cancelEventButton.
     */
    @FXML
    void cancelEventButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) cancelEventButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Adds a new event to a user's schedule based on the
     * information the user has entered in the text fields
     * for the event they want to add to their schedule.
     * 
     * @param event where the user clicks the addEventButton
     */
    @FXML
    void onAddEventButtonClicked(ActionEvent event) {
    	String name = eventNameField.getText();
    	String date = eventDateField.getText();
    	double start;
    	double end;
    	try {
    		String[] splitDateArray = date.split("/");
    		// Checks to see if the start time is less than the end time
    		if (Double.parseDouble(eventStartField.getText()) < Double.parseDouble(eventEndField.getText())) {
				int day = Integer.parseInt(splitDateArray[0]);
        		int month = Integer.parseInt(splitDateArray[1]);
        		int year = Integer.parseInt(splitDateArray[2]);
        		start = Double.parseDouble(eventStartField.getText());
    			end = Double.parseDouble(eventEndField.getText());
    			// Ensures timeframe values are valid.
    			if (start > 0.0 && end < 24.0) {
    				double[] timeFrameArray = {start, end};
        			
            		/*
            		 * Handles invalid values for any of the instance variable
            		 * values of the Event object
            		 */
            		if (year < 0 || year > 3000 ||
            			day > Month.of(month).length(Year.isLeap(year)) ||
            			month > 12 || month < 1 ||
            			start < 0 || end > 24) {
            			// Can be configured to a Label controller later.
            			System.out.println("Please set values within the proper range.");
            		}
            		else {
            			this.eventToAdd = new Event(name, day, month, year, timeFrameArray);
            			Schedule.add(eventToAdd);
            			Stage stage = (Stage) cancelEventButton.getScene().getWindow();
            	        stage.close();    				
            		}
    			}
    		}
    	} catch (Exception NumberFormatException) {
    		System.out.println("that's illegal and you know it");
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert eventNameField != null : "fx:id=\"eventNameField\" was not injected: check your FXML file 'AddEventView.fxml'.";
        assert eventEndField != null : "fx:id=\"eventEndField\" was not injected: check your FXML file 'AddEventView.fxml'.";
        assert eventStartField != null : "fx:id=\"eventStartField\" was not injected: check your FXML file 'AddEventView.fxml'.";
        assert cancelEventButton != null : "fx:id=\"cancelEventButton\" was not injected: check your FXML file 'AddEventView.fxml'.";
        assert eventDateField != null : "fx:id=\"eventDateField\" was not injected: check your FXML file 'AddEventView.fxml'.";
        assert addEventButton != null : "fx:id=\"addEventButton\" was not injected: check your FXML file 'AddEventView.fxml'.";
    }
}

