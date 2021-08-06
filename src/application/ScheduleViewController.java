package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import models.Event;
import models.Schedule;

/**
 * 
 * @author Sidd
 *
 */
public class ScheduleViewController {
	private Schedule schedule;
	
//	public void setSchedule(Schedule schedule) {
//		this.schedule = schedule;
//	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Event> eventListView;
    
    @FXML
    void closeScheduleViewButtonClicked(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    Event viewEventButtonClicked(ActionEvent event) {
    	Event eventToView = eventListView.getSelectionModel().getSelectedItem();
    	return eventToView;
    }

    @FXML
    void initialize() {
        assert eventListView != null : "fx:id=\"eventListView\" was not injected: check your FXML file 'ScheduleView.fxml'.";
        
        this.schedule = new Schedule(2030, 9, 22);
        double[] timeFrameTest = {6.0, 12.0};
        this.schedule.addEvent(new Event("ABC", 22, 9, 2030, timeFrameTest));
        this.schedule.addEvent(new Event("DEF", 22, 9, 2030, timeFrameTest));
        this.schedule.addEvent(new Event("GHI", 22, 9, 2030, timeFrameTest));
        
        eventListView.setItems(FXCollections.observableArrayList(this.schedule.getEvents()));
    }

}
