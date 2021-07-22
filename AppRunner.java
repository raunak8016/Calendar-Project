/**
 * 
 * @author rauna
 * 
 */

import java.util.Scanner;

public class AppRunner {

	public void run() {
		System.out.println("Welcome to the Virtual Calendar!");
		Scanner myObj = new Scanner(System.in);
		
		System.out.print("Enter year: ");
		int year = myObj.nextInt();
		myObj.nextLine();
		
		System.out.print("Enter month number: ");
		int month = myObj.nextInt();
		myObj.nextLine();
		
		System.out.print("Would you like to see a visualization of that month? ");
		String startVisual = myObj.nextLine();
		
		if (startVisual.equalsIgnoreCase("yes")) {
			Calendar showUser = new Calendar(year, month);
			showUser.printMonth();
			System.out.println("");
		}
		System.out.print("Would you like to add an event on a certain day in this calendar? ");
		String addEvent = myObj.nextLine();
		while (addEvent.equalsIgnoreCase("yes")) {
			System.out.println("Enter the name of the event, the day of the event and the start and end time of the event seperated by commas");
			System.out.println("Example: Dentist Appointment,26,5.15,15.30 would be for a Dentist Appointment on the 26th from 5:15 A.M. to 15:30 5P.M.");
			double[] timeArray = new double[2];
			String Event = myObj.nextLine();
			String[] eventInfo = Event.split(",");
			timeArray[0]=Double.parseDouble(eventInfo[2]);
			timeArray[1]=Double.parseDouble(eventInfo[3]);
			Schedule day_i = new Schedule(year, month);
			day_i.addEvent(new Event(eventInfo[1], year, month, Integer.parseInt(eventInfo[2]), timeArray));
			System.out.print("Would you like to add another event on this day?");
			addEvent = myObj.nextLine();
			System.out.print("Would you like to view your schedule on this day?");
			String schedView = myObj.nextLine();
			day_i.scheduleVisualizer();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppRunner calendar1 = new AppRunner();
		calendar1.run();
		

	}

}
