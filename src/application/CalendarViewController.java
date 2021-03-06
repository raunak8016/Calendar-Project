package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Calendar;

/**
 * 
 * @author Sidd
 *
 */
public class CalendarViewController {
	String monthView;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="calendarReprLabel"
    private Label calendarReprLabel; // Value injected by FXMLLoader
    
    
    /**
     * Initializes the Controller class for the viewing
     * of the Calendar selected by the user.
     * 
     * @param test the Calendar object that the user
     * has selected.
     */
    public void Initialize(Calendar test) {
        assert calendarReprLabel != null : "fx:id=\"calendarReprLabel\" was not injected: check your FXML file 'CalendarView.fxml'.";
                
        this.monthView = test.monthRepr();
        
        //set Label to Calendar Visualization
        calendarReprLabel.setText(this.monthView);
    }
    
    
}

