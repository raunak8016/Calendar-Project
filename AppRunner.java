
 /**
 * 
 * @author rauna
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AppRunner {
	/*
	 * Class to run the calendar application
	 */
	public void run() {
		System.out.println("Welcome to the Virtual Calendar!");
		//creating scanner object
		Scanner myObj = new Scanner(System.in);
		
		//taking input for year
		System.out.print("Enter year: ");
		int year = myObj.nextInt();
		myObj.nextLine();
		
		
		//taking input for month
		System.out.print("Enter month number: ");
		int month = myObj.nextInt();
		myObj.nextLine();
		
		//taking input
		System.out.print("Would you like to see a visualization of that month? ");
		String startVisual = myObj.nextLine();
		
		//showing calendar visualization if user opts in
		if (startVisual.equalsIgnoreCase("yes")) {
			Calendar showUser = new Calendar(year, month);
			showUser.printMonth();
			System.out.println("");
		}
		
		//moving on to ask user for input about whether they want to add an event to a day in the calendar
		System.out.print("Would you like to add an event on a certain day in this calendar? ");
		String addEvent = myObj.nextLine();
		
		//if no exit the program
		if (addEvent.equalsIgnoreCase("no")) System.exit(0);
		
		//initiate new Schedule class if they have opted to add event to Schedule for a certain day
		Schedule scheduleDays=new Schedule(year, month);
		
		//continue to ask them for input if they have not said they do not want to add any more events
		while (addEvent.equalsIgnoreCase("yes")) {
			System.out.println("Enter the name of the event, the day of the event and the start and end time of the event seperated by commas");
			System.out.println("Example: Dentist Appointment,26,5.15,15.30 would be for a Dentist Appointment on the 26th from 5:15 A.M. to 15:30 P.M.");
			double[] timeArray = new double[2]; //array for timeframe to initate event object
			
			String Event = myObj.nextLine();
			String[] eventInfo = Event.split(","); //split the user input to generate data to create event class
			
			timeArray[0]= Double.parseDouble(eventInfo[2]); //start time
			timeArray[1]= Double.parseDouble(eventInfo[3]); //end time

			//add new event object to new schedule object
			scheduleDays.getEvents().add(new Event(eventInfo[0], Integer.parseInt(eventInfo[1]), month, year, timeArray));
			
			//ask for input once again
			System.out.print("Would you like to add another event on this day? ");
			addEvent = myObj.nextLine();

		}
		System.out.print("Would you like to view your schedule for this a day: ");
		String schedView = myObj.nextLine();
		if(schedView.equalsIgnoreCase("no")) {
			System.exit(0);
		}
		else if (schedView.equalsIgnoreCase("yes")) {
				//display schedule visualization
				System.out.println(scheduleDays.scheduleVisualizer());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//run application with run method 
		AppRunner calendar1 = new AppRunner();
		calendar1.run();
	}

}