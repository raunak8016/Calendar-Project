package application;

import java.util.HashMap;
import java.util.Scanner;

import models.Calendar;
import models.Event;
import models.Schedule;

/**
 * 
 * @author raunak
 * 
 */

public class Interface {
	HashMap<String, Calendar> calendars = new HashMap<String, Calendar>();
	Scanner userInput = new Scanner(System.in);
	/*
	 * Displays welcome header when program is first run
	 */
	public void displayWelcomeHeader() {
		System.out.println("Welcome to the new and improved Virtual Calendar,"
				+ "\nyour very own calendar for scheduling events!"
				+ "\nTo start, pick an option from the menu by typing"
				+ "\nin the text next to the options to choose an action.\n");
	}
	/*
	 * method to display options in the menu 
	 */
	public void displayOptions() {
		if (calendars.isEmpty()) {
			System.out.println("\n> Create a calendar ('create')");
		} else {
			System.out.println("\n> Add another calendar ('create')"
					+ "\n> View calendar and events by date ('view')"
					+ "\n> Schedule an event ('schedule')"
					+ "\n> Exit application ('exit')\n");
		}
	}
	/*
	 * Invalid input method printout
	 */
	public String invalidInput(Scanner inputObject) {
		System.out.println("Invalid input, please try again\n");
		return inputObject.nextLine();
	}
	/*
	 * Exit application printout method
	 */
	public void exitApplication() {
		System.out.println("Exiting application");
		System.exit(0);
	}
	/*
	 * Returns the year and month as a hashmap after receiving user input
	 */
	public HashMap<String, Integer> returnYearandMonth() {
		System.out.print("\nEnter year: ");
		int year = userInput.nextInt(); //user input for year
		userInput.nextLine();

		System.out.print("\nEnter month number: ");
		int month = userInput.nextInt(); //user input for month
		userInput.nextLine();
		
		HashMap<String, Integer> ret = new HashMap<String, Integer>(); //store information as a Hashmap
		ret.put("year", year);
		ret.put("month", month);
		return ret; //return Hashmap
	}
	/*
	 * method to return calendars as a string
	 */
	public String getCalendars() {
		return calendars.toString();
	}
	/*
	 * method to add a new calendar to the list of Calendars
	 */
	public void addCalendar(){
		HashMap<String, Integer> calendarArgs = returnYearandMonth();
		
		int year = calendarArgs.get("year"); //fetch year from Hashmap
		int month = calendarArgs.get("month"); //fetch month from Hashmap
		
		Calendar newCalendar = accessCalendarForUser(year, month);
		calendars.put(newCalendar.toString(), newCalendar); //add NewCalendar to Calendars hashmap
		System.out.println("\nCalendar successfully created!\n");
	}
	/*
	 * Method to view a calendar from the Hashmap calendars
	 */
	public void viewCalendar() {
		System.out.println("\nHere are all of your current calendars."
				+ "\nwhich one would you like to view?");
		
		System.out.println("\n" + calendars.keySet().toString()); //display list of calendars
		
		HashMap<String, Integer> calendarArgs = returnYearandMonth();
		
		int year = calendarArgs.get("year");
		int month = calendarArgs.get("month");
		
		Calendar calendarInstance = calendars.get(Calendar.toKeyFormattedString(year, month));
		
		if (calendarInstance != null) {
			System.out.println("");
			calendarInstance.printMonth();
			System.out.println("");
			/*System.out.println("\n+Would you like to view a schedule? ");
			switch (userInput.nextLine()) {
				case "yes":
					scheduleVisual(year, month, calendarInstance.accessScheduleForUser());
					break;
				default:
					break;
			}*/
			
		}
		else
			System.out.println("Error: Calendar does not exist ");
	}
	/*
	 * Method to schedule an Event for a user on a certain day
	 */
	public void scheduleEventForUser() {
		System.out.println("\nHere are all of your current calendars."
				+ "\nwhich one would you like to create a schedule for?");
		
		System.out.println("\n" + calendars.keySet().toString()); //display list of calendars
		HashMap<String, Integer> calendarArgs = returnYearandMonth();
		int year = calendarArgs.get("year");
		int month = calendarArgs.get("month");
		
		System.out.print("Would you like to add an event to your schedule? ");
		String addEvent = userInput.nextLine();
		// Creates Schedule instance.
		Schedule scheduleDays = calendars.get(Calendar.toKeyFormattedString(year, month)).accessScheduleForUser();

		/*
		 * Keeps a while loop that only breaks once the user does not want to add more events
		 * to their schedule by inputting 'no' into the interface when given the choice.
		 */
		while (addEvent.equalsIgnoreCase("yes")) {
			System.out.println("Enter the name of the event, the day of the event and the start and end time of the event seperated by commas");
			System.out.println("Example: 'Dentist Appointment, 26, 5.15, 15.30' would be for a Dentist Appointment on the 26th from 5:15 A.M. to 15:30 P.M.");
			/*
			 * Creates a new array filled with type 'double', and passes as an argument for 
			 * Event instance variable eventTimeFrame.
			 */
			double[] timeArray = new double[2];
			// Takes and splits user input for arguments.
			String Event = userInput.nextLine();
			String[] eventInfo = Event.split(", ");

			// Adds values to timeArray to pass as argument for eventTimeFrame.
			timeArray[0] = Double.parseDouble(eventInfo[2]);
			timeArray[1] = Double.parseDouble(eventInfo[3]);

			// Adds Event instance.
			scheduleDays.getEvents().add(new Event(eventInfo[0], Integer.parseInt(eventInfo[1]), month, year, timeArray));
			
			// Continues conditional loop for adding events to Schedule instance.
			System.out.print("Would you like to add another event to your schedule? ");
			addEvent = userInput.nextLine();
		}
		this.scheduleVisual(year, month, scheduleDays);
	}
	
	public void scheduleVisual(int year, int month, Schedule scheduleDays) {
		System.out.print("Would you like to view your schedule: ");
		String schedView = userInput.nextLine();		
		// Exits if user does not want Schedule visualization
		if(schedView.equalsIgnoreCase("no"))
			System.exit(0);
		else if (schedView.equalsIgnoreCase("yes"))
			System.out.println(scheduleDays.scheduleVisualizer());
	}
	
	/**
	 * Takes a year and month as a parameter
	 * to access a Calendar instance in
	 * calendars
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public Calendar accessCalendarForUser(int year, int month) {
		Calendar calendar = calendars.get(Calendar.toKeyFormattedString(year, month));
		if (calendar != null)
			return calendar;
		else
			return new Calendar(year, month);
	}
	
}
