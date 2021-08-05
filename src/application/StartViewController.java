package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Calendar;

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
    

    @FXML
    void submitButtonClicked(ActionEvent event) {
    	int year;
    	int month;
    	try {
    		if (Integer.parseInt(yearField.getText())>=0 && (Integer.parseInt(monthField.getText())>0 
    				&& Integer.parseInt(monthField.getText())<=12)) {
    			year = Integer.parseInt(yearField.getText());
        		month = Integer.parseInt(monthField.getText());
        		appRunner.mainView(year, month);
    		}
    		else {
    			topLabelMessage.setText("Invalid numbers entered for year and month");
    		}
    	} catch (Exception NumberFormatException ) {
    		topLabelMessage.setText("Enter numerical values for year and month");
    	}
    	
    }

	public void linkWithApplication(GUIApplication guiApplication) {
		// TODO Auto-generated method stub
		appRunner = guiApplication;
	}


}
