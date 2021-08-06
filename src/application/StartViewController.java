package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Calendar;

/**
 * 
 * @author raunak
 *
 */
public class StartViewController {

    @FXML
    private Button submitButton;

    @FXML
    private TextField yearField;

    @FXML
    private TextField monthField;

    @FXML
    private Label topLabelMessage;
    
    GUIApplication appRunner;
    
    /**
     * Adds a Calendar based on whether or not the
     * Submit button was clicked within the GUI
     * when the user enters in the values they
     * want for the new Calendar they created.
     * 
     * @param event where the user clicks the
     * 'Submit' button within the GUI.
     */
    @FXML
    void submitButtonClicked(ActionEvent event) {
    	int year;
    	int month;
    	try {
    		if (Integer.parseInt(yearField.getText())>=0 && (Integer.parseInt(monthField.getText())>0 
    				&& Integer.parseInt(monthField.getText())<=12)) {
    			//sets month and year equal to user input if it is valid and then switches to MainView
    			year = Integer.parseInt(yearField.getText());
        		month = Integer.parseInt(monthField.getText());
        		appRunner.mainView(year, month);
    		}
    		else {
    			//Error Message
    			topLabelMessage.setText("Invalid numbers entered for year and month");
    		}
    	} catch (Exception NumberFormatException ) {
    		//Error Message
    		topLabelMessage.setText("Enter numerical values for year and month");
    	}
    	
    }

    /**
     * Links with the main GUIApplication so it can
     * implement this controller class along with
     * its view.
     * 
     * @param guiApplication the main GUIApplication
     * instance that all other controllers are
     * linked to.
     */
	public void linkWithApplication(GUIApplication guiApplication) {
		// TODO Auto-generated method stub
		appRunner = guiApplication;
	}


}
