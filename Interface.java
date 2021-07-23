import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author raunak
 * 
 */

public class Interface {
	ArrayList<Calendar> calendars = new ArrayList<Calendar>();
	
	public void calendarVisual(int year, int month) {
		/*
		 * Presents Calendar month visualization
		 * based on user input.
		 */
		Scanner myObj = new Scanner(System.in);
		System.out.print("Would you like to see a visualization of that month? ");
		String startVisual = myObj.nextLine();
		
		if (startVisual.equalsIgnoreCase("yes")) {
			Calendar showUser = new Calendar(year, month);
			calendars.add(showUser);
			showUser.printMonth();
			System.out.println("");
		}
	}
	
	public void addEventbyUser(int year, int month) {
		Scanner myObj = new Scanner(System.in);
		System.out.print("Would you like to add an event on a certain day in this calendar? ");
		String addEvent = myObj.nextLine();
		// Creates Schedule instance.
		Schedule scheduleDays = new Schedule(year, month);

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
			String Event = myObj.nextLine();
			String[] eventInfo = Event.split(", ");

			// Adds values to timeArray to pass as argument for eventTimeFrame.
			timeArray[0] = Double.parseDouble(eventInfo[2]);
			timeArray[1] = Double.parseDouble(eventInfo[3]);

			// Adds Event instance.
			scheduleDays.getEvents().add(new Event(eventInfo[0], Integer.parseInt(eventInfo[1]), month, year, timeArray));

			// Continues conditional loop for adding events to Schedule instance.
			System.out.print("Would you like to add another event on this day? ");
			addEvent = myObj.nextLine();
		}
	}
	
	public void scheduleVisual(int year, int month, Schedule scheduleDays) {
		Scanner myObj = new Scanner(System.in);
		System.out.print("Would you like to view your schedule for this a day: ");
		String schedView = myObj.nextLine();
		
		// Exits if user does not want Schedule visualization
		if(schedView.equalsIgnoreCase("no"))
			System.exit(0);
		else if (schedView.equalsIgnoreCase("yes"))
				System.out.println(scheduleDays.scheduleVisualizer());
	}
	
	/**
	 * This method runs the entire application
	 * along with providing the text-based
	 * interface of the command prompt/terminal.
	 */
	public Calendar accessCalendarForUser(int year, int month) {
		boolean calendarExists = false;
		for (Calendar calendar : calendars) {
			if (calendar.getYear() == year && calendar.getMonth() == month) {
				calendarExists = true;
				return calendar;
			}
		}
		return new Calendar(year, month);
	}
		
	public void seeCalendarVisualization(int year, int month) {
		/*
		 * Presents Calendar month visualization
		 * based on user input.
		 */

		Scanner myObj = new Scanner(System.in);

		System.out.print("\nWould you like to see a visualization of that month? \n"
				+ "\n> yes"
				+ "\n> no"
				+ "\n> exit");

		if (myObj.nextLine().equalsIgnoreCase("yes")) {
			accessCalendarForUser(year, month).printMonth();
		}
		else if (myObj.nextLine().equalsIgnoreCase("no")) {
			System.out.println("returning back to the main menu...\n");
			//return to main;
		}
		else if (myObj.nextLine().equalsIgnoreCase("quit") || myObj.nextLine().equalsIgnoreCase("exit")) {
			System.out.println("exiting application");
			System.exit(0);
		}
	}
	
}


