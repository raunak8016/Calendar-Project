package application;

import java.net.URL;
import java.time.Month;
import java.time.Year;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Event;

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

    @FXML
    void cancelEventButtonClicked(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    Event onAddEventButtonClicked(ActionEvent event) {
    	String name = eventNameField.getText();
    	String date = eventDateField.getText();
    	double start;
    	double end;
    	
    	try {
    		String[] splitDateArray = date.split("/");
    		if (Double.parseDouble(eventStartField.getText()) < Double.parseDouble(eventEndField.getText())) {
				int day = Integer.parseInt(splitDateArray[0]);
        		int month = Integer.parseInt(splitDateArray[1]);
        		int year = Integer.parseInt(splitDateArray[2]);
        		start = Double.parseDouble(eventStartField.getText());
    			end = Double.parseDouble(eventEndField.getText());
    			
    			double[] timeFrameArray = {start, end};
    			
        		/*
        		 * Handles invalid values for any of the instance variable
        		 * values of the Event object
        		 */
        		if (year < 0 || year > 3000 ||
        			day > Month.of(month).length(Year.isLeap(year)) ||
        			month > 12 || month < 1) {
        			// Can be configured to a Label controller later.
        			System.out.println("Please set values within the proper range.");
        		}
        		else {
        			this.eventToAdd = new Event(name, day, month, year, timeFrameArray);
        			System.out.println(this.eventToAdd.toString());
        		}
    		}
    	} catch (Exception NumberFormatException) {
    		System.out.println("that's illegal and you know it");
    	}
    	return this.eventToAdd;
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

