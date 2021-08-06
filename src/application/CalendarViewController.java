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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert calendarReprLabel != null : "fx:id=\"calendarReprLabel\" was not injected: check your FXML file 'CalendarView.fxml'.";
        
        Calendar calendar = new Calendar(2012, 2);
        
        this.monthView = calendar.monthRepr();
        
        calendarReprLabel.setText(this.monthView);
    }
}

