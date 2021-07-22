import java.util.Scanner;

/**
 * 
 * @author raunak
 * 
 */

public class AppRunner {
	/**
	 * This method runs the entire application
	 * along with providing the text-based
	 * interface of the command prompt/terminal.
	 */
	public void run() {
		// Start of interface
		System.out.println("Welcome to the Virtual Calendar! ");
		Scanner myObj = new Scanner(System.in);
		
		/*
		 *  Gets information for Calendar
		 *  year and month.
		 */
		System.out.print("Enter year: ");
		int year = myObj.nextInt();
		myObj.nextLine();
		
		System.out.print("Enter month number: ");
		int month = myObj.nextInt();
		myObj.nextLine();
		
		/*
		 * Presents Calendar month visualization
		 * based on user input.
		 */
		System.out.print("Would you like to see a visualization of that month? ");
		String startVisual = myObj.nextLine();
		
		if (startVisual.equalsIgnoreCase("yes")) {
			Calendar showUser = new Calendar(year, month);
			showUser.printMonth();
			System.out.println("");
		}
		
		System.out.print("Would you like to add an event on a certain day in this calendar? ");
		String addEvent = myObj.nextLine();
		
		if (addEvent.equalsIgnoreCase("no"))
			System.exit(0);
		
		// Creates Schedule instance.
		Schedule scheduleDays = new Schedule(year, month);
		
		/*
		 * Keeps a while loop that only breaks once
		 * the user does not want to add more events
		 * to their schedule by inputting 'no' into
		 * the interface when given the choice.
		 */
		while (addEvent.equalsIgnoreCase("yes")) {
			System.out.println("Enter the name of the event, the day of the event and the start and end time of the event seperated by commas");
			System.out.println("Example: 'Dentist Appointment, 26, 5.15, 15.30' would be for a Dentist Appointment on the 26th from 5:15 A.M. to 15:30 P.M.");
			/*
			 * Creates a new array filled with type 'double',
			 * and passes as an argument for Event instance
			 * variable eventTimeFrame.
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
		
		System.out.print("Would you like to view your schedule for this a day: ");
		String schedView = myObj.nextLine();
		
		// Exits if user does not want Schedule visualization
		if(schedView.equalsIgnoreCase("no"))
			System.exit(0);
		else if (schedView.equalsIgnoreCase("yes"))
				System.out.println(scheduleDays.scheduleVisualizer());
	}
	
	/**
	 * Runs application with run() method.
	 */
	public static void main(String[] args) {
		AppRunner calendar = new AppRunner();
		calendar.run();
	}

}