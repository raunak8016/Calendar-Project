import java.util.Scanner;

/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	
	public void welcome() {
		System.out.println("Welcome to the new and improved Virtual Calendar,"
				+ "\nyour very own calendar for scheduling events!\n"
				+ "\nTo start, pick an option from the menu by typing"
				+ "\nin the text next to the options to choose an action.");
		callMenu();
	}
	
	public void callMenu() {
		System.out.println("\n> Add a calendar ('add')");
		
		Scanner myObject = new Scanner(System.in);
		
		if (calendars.isEmpty()) {
			String input = myObject.nextLine();
			while (!input.equalsIgnoreCase("add")) {
				if (input == "exit") {
					System.out.println("exiting to main menu\n");
					break;
				}
				else {
					System.out.println("Invalid input, please try again\n");
					input = myObject.nextLine();
				}
			}
			System.out.print("\nEnter year: ");
			int year = myObject.nextInt();
			myObject.nextLine();

			System.out.print("\nEnter the number of the month you want (e.g. January is 1, February is 2...): ");
			int month = myObject.nextInt();
			myObject.nextLine();
			
			calendars.add(accessCalendarForUser(year, month));
			
			System.out.println("Calendar successfully added!");
			
			this.callMenu();
		}
		else {
			boolean stayInLoop = true;
			while (stayInLoop) {
				System.out.println("> Create a calendar ('create')"
						+ "\n> View calendar and events by date ('view')"
						+ "\n> Schedule an event ('schedule')"
						+ "\n> Exit application ('exit')");
				String input = myObject.nextLine();
				switch (input) {
					case "create":
						System.out.print("\nEnter year: ");
						int year = myObject.nextInt();
						myObject.nextLine();

						System.out.print("\nEnter month number: ");
						int month = myObject.nextInt();
						myObject.nextLine();
						
						calendars.add(accessCalendarForUser(year, month));
						break;
					case "view":
						System.out.print("\nEnter year: ");
						year = myObject.nextInt();
						myObject.nextLine();

						System.out.print("\nEnter month number: ");
						month = myObject.nextInt();
						myObject.nextLine();
						
						seeCalendarVisualization(year, month);
						break;
					case "schedule":
						System.out.print("\nEnter year: ");
						year = myObject.nextInt();
						myObject.nextLine();

						System.out.print("\nEnter month number: ");
						month = myObject.nextInt();
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
