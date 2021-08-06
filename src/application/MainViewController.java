package application;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Calendar;

/**
 * 
 * @author raunak
 *
 */
public class MainViewController {

    @FXML
    private ChoiceBox<String> calendarChoiceBox;

    @FXML
    private Button quitButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button addEventButton;

    @FXML
    private Button viewScheduleButton;
    
    @FXML
    private Button createCalendar;
    
    private static Interface Calendars = new Interface();
    
    GUIApplication appRunner;
    
    
    public void setCalendarChoices() {
    	String[] calendarStrings = new String[Calendars.calendars.size()];
    	int count = 0;
    	for (Calendar i : Calendars.calendars.values()) {
    		calendarStrings[count] = i.toString();
    		count++;
    	}
    	calendarChoiceBox.setItems(FXCollections.observableArrayList(calendarStrings));
    	calendarChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    void viewButtonClicked(ActionEvent event) {
    	String selectedItem = calendarChoiceBox.getSelectionModel().getSelectedItem();
    	appRunner.calendarView(Calendars.calendars.get(selectedItem));
    }
    
    @FXML
    void createCalendarClicked(ActionEvent event) {
    	appRunner.startView();
    }

    @FXML
    void addEventButtonClicked(ActionEvent event) {
    	appRunner.addEventView();
    }

    @FXML
    void viewScheduleButtonClicked(ActionEvent event) {
    	appRunner.scheduleView();
    }

    @FXML
    void quitButtonClicked(ActionEvent event) {
        System.exit(0);
    }

	public void setCalendar(int year, int month) {
		// TODO Auto-generated method stub
		Calendar userGen = new Calendar(year, month);
		
		Calendars.calendars.put(userGen.toString(), userGen);
		setCalendarChoices();
	}
	
	public void linkWithApplication(GUIApplication guiApplication) {
		// TODO Auto-generated method stub
		appRunner = guiApplication;
	}

}
