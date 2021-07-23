import java.util.Scanner;

/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	
	public void callMenu() {
		System.out.println("Welcome to the new and improved Virtual Calendar,"
				+ "\nyour very own calendar for scheduling events!\n"
				+ "\nTo start, pick an option from the menu by typing"
				+ "\nin the text next to the options to choose an action.");
		
		System.out.println("\n> Add a calendar ('add') ");
		
		Scanner myObject = new Scanner(System.in);
		String input = myObject.nextLine();
		
		if (calendars.isEmpty()) {
			input = myObject.nextLine();
			while (!input.equalsIgnoreCase("add")) {
				if (input == "exit") {
					System.out.println("exiting to main menu\n");
					break;
				}
				else {
					System.out.println("Invalid input, please try again\n");
				}
			}
		}
		else {
			System.out.println("\n> Create a calendar ('create')"
					+ "\n> View calendar and events by date ('view')"
					+ "\n> Schedule an event ('schedule')"
					+ "\n> Exit application ('exit')");
			boolean stayInLoop = true;
			while (stayInLoop) {
				input = myObject.nextLine();
				switch (input) {
					case "create":
						System.out.println("0");
						
						break;
					case "view":
						System.out.println("1");
						break;
					case "schedule":
						System.out.println("2");
						break;
					case "exit":
						System.out.println("3");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, please try again\n");
				}
			}
		}
	}
	
	public String toString() {
		return "xyz";
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.callMenu();
	}

}
