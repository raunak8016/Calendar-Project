package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Event;

/**
 * 
 * @author Sidd
 *
 */
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
        
        double[] sampleTimes = {3.0, 15.15};
        
        this.event = new Event("test event", 21, 3, 2020, sampleTimes);
        
        nameOutputLabel.setText(this.event.getEventName());
        startsOutputLabel.setText(Double.toString(this.event.getEventTimeFrame()[0]));
        endsOutputLabel.setText(Double.toString(this.event.getEventTimeFrame()[1]));
        dateOutputLabel.setText(String.format("%s %s, %s", this.event.getEventDay(), this.event.getEventMonth(), this.event.getEventYear()));
        lengthOutputLabel.setText(Double.toString(this.event.getEventTimeFrame()[1] - this.event.getEventTimeFrame()[0]));
        
    }
    
}
