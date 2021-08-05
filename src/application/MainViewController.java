package application;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Calendar;

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
    
    private Interface Calendars = new Interface();
    
    
    public void setCalendarChoices() {
    	String[] calendarStrings = new String[Calendars.calendars.size()];
    	int count = 0;
    	for (Calendar i : Calendars.calendars.values()) {
    		calendarStrings[count] = i.toString();
    		count++;
    	}
    	calendarChoiceBox.setItems(FXCollections.observableArrayList(calendarStrings));
    }

    @FXML
    void viewButtonClicked(ActionEvent event) {

    }

    @FXML
    void addEventButtonClicked(ActionEvent event) {

    }

    @FXML
    void viewScheduleButtonClicked(ActionEvent event) {

    }

    @FXML
    void quitButtonClicked(ActionEvent event) {
        System.exit(0);
    }

	public void setCalendar(int year, int month) {
		// TODO Auto-generated method stub
		Calendar userGen = new Calendar(year, month);
		
		Calendars.calendars.put(userGen.toString(), userGen);
		System.out.println(Calendars.calendars);
		setCalendarChoices();
	}

}
