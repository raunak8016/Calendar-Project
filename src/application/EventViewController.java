package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Event;

public class EventViewController {
	private Event event;
	
	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

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
    void initialize() {
        assert nameOutputLabel != null : "fx:id=\"nameOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert dateOutputLabel != null : "fx:id=\"dateOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert startsOutputLabel != null : "fx:id=\"StartsOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert endsOutputLabel != null : "fx:id=\"endsOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        assert lengthOutputLabel != null : "fx:id=\"lengthOutputLabel\" was not injected: check your FXML file 'EventView.fxml'.";
        
        nameOutputLabel.setText(event.getEventName());
        nameOutputLabel.setText(Double.toString(event.getEventTimeFrame()[0]));
        nameOutputLabel.setText(Double.toString(event.getEventTimeFrame()[1]));
        nameOutputLabel.setText(String.format("%s %s, %s", event.getEventDay(), event.getEventMonth(), event.getEventYear()));
        nameOutputLabel.setText(Double.toString(event.getEventTimeFrame()[1] - event.getEventTimeFrame()[0]));
        
    }
    
}
