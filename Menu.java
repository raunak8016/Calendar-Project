import java.time.Month;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	
	public void welcome() {
		System.out.println("Welcome to the new and improved Virtual Calendar,"
				+ "\nyour very own calendar for scheduling events!"
				+ "\nTo start, pick an option from the menu by typing"
				+ "\nin the text next to the options to choose an action.\n");
		callMenu();
	}
	
	public void callMenu() {		
		Scanner myObject = new Scanner(System.in);
		
		if (calendars.isEmpty()) {
			System.out.println("\n> Create a calendar ('create')");
			String input = myObject.nextLine();
			while (!input.equalsIgnoreCase("create")) {
				if (input == "exit") {
					System.out.println("exiting to main menu\n");
					break;
				}
				else {
					System.out.println("Invalid input, please try again\n");
					input = myObject.nextLine();
				}
			}
			addCalendar();
			System.out.println("\nCalendar successfully created!");
			this.callMenu();
		}
		else {
			boolean stayInLoop = true;
			while (stayInLoop) {
				System.out.println("\n> Add another calendar ('add')"
						+ "\n> View calendar and events by date ('view')"
						+ "\n> Schedule an event ('schedule')"
						+ "\n> Exit application ('exit')\n");
				String input = myObject.nextLine();
				switch (input) {
					case "create":
						addCalendar();
						break;
					case "view":
						viewCalendar();
						break;
					case "schedule":
						System.out.print("\nEnter year: ");
						int year = myObject.nextInt();
						myObject.nextLine();

						System.out.print("\nEnter month number: ");
						int month = myObject.nextInt();
						myObject.nextLine();
						
						break;
					case "exit":
						System.out.println("3");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, please try again\n");
				}
			}
			this.callMenu();
		}
	}
	
	public String toString() {
		return "xyz";
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.welcome();
	}

}
