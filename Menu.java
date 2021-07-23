import java.util.Scanner;

/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	/*
	 * method to return to main menu
	 */
	public void returnToMainMenu() {
		System.out.println("\nreturning to main menu\n");
		start();
	}
	/*
	 * Method which initializes the entire application and connects all the menu options through
	 * the interface methods
	 */
	public void start() {
		if (calendars.isEmpty()) displayWelcomeHeader(); //if there are no Calendars created, the welcome banner is first displayed
		
		displayOptions(); //menu options are displayed
		
		if (calendars.isEmpty()) {
			String input = userInput.nextLine();
			while (!input.equalsIgnoreCase("create")) {
				if (input == "exit") {
					returnToMainMenu();
					break;
				}
				else {
					input = invalidInput(userInput);
				}
			}
			addCalendar();
		}
		else {
			//code for the menu functionality
			boolean stayInLoop = true;
			while (stayInLoop) { //while inside the foreloop the menu will be displayed after each user input runs 
				String input = userInput.nextLine();
				switch (input) {
					case "create":
						addCalendar();
						break;
					case "view":
						viewCalendar();
						break;
					case "schedule":
						scheduleEventForUser();
						break;
					case "return":
						returnToMainMenu();
						break;
					case "exit":
						exitApplication();
						break;
					default:
						input = invalidInput(userInput);
				}
			}
		}
		returnToMainMenu();
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.start();
	}

}
