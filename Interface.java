import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author raunak
 * 
 */

public class Interface {
	HashMap<String, Calendar> calendars = new HashMap<String, Calendar>();
	Scanner userInput = new Scanner(System.in);
	
	/**
	 * Displays starting header in application for new users.
	 */
	public void displayWelcomeHeader() {
		System.out.println("Welcome to the new and improved Virtual Calendar,"
				+ "\nyour very own calendar for scheduling events!"
				+ "\nTo start, pick an option from the menu by typing"
				+ "\nin the text next to the options to choose an action.\n");
	}
	
	/**
	 * Displays options of the main menu for the user
	 * to pick based on what action they want to do.
	 */
	public void displayOptions() {
		if (calendars.isEmpty()) {
			System.out.println("\n> Create a calendar ('create')");
		} else {
			System.out.println("\n> Add another calendar ('add')"
					+ "\n> View calendar and events by date ('view')"
					+ "\n> Schedule an event ('schedule')"
					+ "\n> Exit application ('exit')\n");
		}
	}
	
	/**
	 * Handles an invalid input by returning a newly
	 * prompted user input, which is handled as a
	 * a user input itself.
	 *
	 * @return
	 */
	public String invalidInput() {
		System.out.println("Invalid input, please try again\n");
		return userInput.nextLine();
	}
	
	/**
	 * Presents dialogue once user has chosen to
	 * exit the application, and then exits.
	 */
	public void exitApplication() {
		System.out.println("Exiting application");
		System.exit(0);
	}
	
	/**
	 * @return a HashMap object to use values
	 * as parameters for other functions.
	 */
	public HashMap<String, Integer> returnYearandMonth() {
		System.out.print("\nEnter year: ");
		int year = userInput.nextInt();
		userInput.nextLine();

		System.out.print("\nEnter month number: ");
		int month = userInput.nextInt();
		userInput.nextLine();
		
		HashMap<String, Integer> ret = new HashMap<String, Integer>();
		ret.put("year", year);
		ret.put("month", month);
		return ret;
	}
	
	/**
	 * @return the calendars to get as String object
	 */
	public String getCalendars() {
		return calendars.toString();
	}
	
	/**
	 * Adds Calendar instance to calendars if it doesn't exist.
	 * If the instance exists, the same object is just re-added
	 * to calendars.
	 */
	public void addCalendar(){
		HashMap<String, Integer> calendarArgs = returnYearandMonth();
		
		int year = calendarArgs.get("year");
		int month = calendarArgs.get("month");
		
		Calendar newCalendar = accessCalendarForUser(year, month);
		calendars.put(newCalendar.toString(), newCalendar);
		System.out.println("\nCalendar successfully created!");
	}
	
	/**
	 * gives user a view of the specified Calendar instance
	 * if it exists. If not, it asks for a valid input
	 * to find a Calendar.
	 */
	public void viewCalendar() {
		while (true) {
			System.out.println("\nHere are all of your current calendars."
					+ "\nwhich one would you like to view?");
			System.out.println("\n" + calendars.keySet().toString());
			
			HashMap<String, Integer> calendarArgs = returnYearandMonth();
			
			int year = calendarArgs.get("year");
			int month = calendarArgs.get("month");
			
			Calendar calendarInstance = calendars.get(Calendar.toKeyFormattedString(year, month));
			
			if (calendarInstance != null) {
				calendarInstance.printMonth();
				System.out.println("Would you like to view a schedule? ");
				if (userInput.nextLine() == "yes") {
					scheduleVisual(year, month, calendarInstance.accessScheduleForUser());
					break;
				}
			}
			else {
				System.out.println("Error: Calendar does not exist \n");
			}
		}
	}
	
	/**
	 * Schedules an event for the user by asking for
	 * its month and date.
	 */
	public void scheduleEventForUser() {
		HashMap<String, Integer> calendarArgs = returnYearandMonth();
		int year = calendarArgs.get("year");
		int month = calendarArgs.get("month");
		
		System.out.print("Would you like to add an event on a certain day in this calendar? ");
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
			System.out.print("Would you like to add another event on this day? ");
			addEvent = userInput.nextLine();
		}
	}
	
	/**
	 * Navigates to provide a schedule visualization if
	 * the user indicates that they want to see one.
	 * 
	 * @param year of the Schedule instance
	 * @param month of the Schedule instance
	 * @param scheduleDays Schedule instance
	 */
	public void scheduleVisual(int year, int month, Schedule scheduleDays) {
		System.out.print("Would you like to view your schedule for this day? ");
		String schedView = userInput.nextLine();
		
		// Exits if user does not want Schedule visualization
		if(schedView.equalsIgnoreCase("no"))
			System.exit(0);
		else if (schedView.equalsIgnoreCase("yes"))
				System.out.println(scheduleDays.scheduleVisualizer());
	}
	
	/**
	 * Takes a year and month as a parameter to access
	 * a Calendar instance in calendars.
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