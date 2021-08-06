package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.Event;

/**
 * 
 * @author Sidd
 *
 */
public class EventViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label nameOutputLabel;

    @FXML
    private Label dateOutputLabel;
    
    @FXML
    private Label startsOutputLabel;

    @FXML
    private Label endsOutputLabel;

    @FXML
    private Label lengthOutputLabel;
    
    @FXML
    private Button closeButton;
    
    @FXML
    void closeButtonClicked(ActionEvent event) {
    	Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    public Event chooseEvent(int index) {
        return AddEventViewController.Schedule.get(index);
    }

    void initialize(int index) {
        assert nameOutputLabel != null : "fx:id=\"nameOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert dateOutputLabel != null : "fx:id=\"dateOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert startsOutputLabel != null : "fx:id=\"StartsOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert endsOutputLabel != null : "fx:id=\"endsOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert lengthOutputLabel != null : "fx:id=\"lengthOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        
        Event passOn = this.chooseEvent(index);
        

        nameOutputLabel.setText(passOn.getEventName());
        startsOutputLabel.setText(Double.toString(passOn.getEventTimeFrame()[0]));
        endsOutputLabel.setText(Double.toString(passOn.getEventTimeFrame()[1]));
        dateOutputLabel.setText(String.format("%s %s, %s", passOn.getEventDay(), passOn.getEventMonth(), passOn.getEventYear()));
        lengthOutputLabel.setText(Double.toString(passOn.getEventTimeFrame()[1] - passOn.getEventTimeFrame()[0]));
        
    }
    
}
