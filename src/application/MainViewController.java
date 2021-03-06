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
    
    /**
     * Sets the choice of calendars based on whichever
     * ones have been created by the user.
     */
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

    /**
     * Switches to CalendarView when view button
     * is clicked
     * @param event
     */
    @FXML
    void viewButtonClicked(ActionEvent event) {
    	String selectedItem = calendarChoiceBox.getSelectionModel().getSelectedItem();
    	appRunner.calendarView(Calendars.calendars.get(selectedItem));
    }
    
    /**
     * switches to CreateCalendarView
     * when creat button is clicked
     * @param event
     */
    @FXML
    void createCalendarClicked(ActionEvent event) {
    	appRunner.startView();
    }

    /**
     * Switches to AddEventView when addEventButton
     * is clicked
     * @param event
     */
    @FXML
    void addEventButtonClicked(ActionEvent event) {
    	appRunner.addEventView();
    }

    /**
     * Switches to viewScheduleView when 
     * viewScheduleButton is clicked
     * @param event
     */
    @FXML
    void viewScheduleButtonClicked(ActionEvent event) {
    	appRunner.scheduleView();
    }

    /**
     * Quits application when quitButton
     * is clicked
     * @param event
     */
    @FXML
    void quitButtonClicked(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Sets the Calendar year and month based
     * on user generated input.
     * @param year
     * @param month
     */
	public void setCalendar(int year, int month) {
		// TODO Auto-generated method stub
		Calendar userGen = new Calendar(year, month);
		
		Calendars.calendars.put(userGen.toString(), userGen);
		setCalendarChoices();
	}
	
	/**
	 * Links the Controller class with the instance of the
	 * main GUIApplication.
	 * 
	 * @param guiApplication the Application that links
	 * the Controller components.
	 */
	public void linkWithApplication(GUIApplication guiApplication) {
		// TODO Auto-generated method stub
		appRunner = guiApplication;
	}

}
