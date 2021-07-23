import java.util.Scanner;

/**
 * 
 * @author Sidd
 *
 */

public class Menu extends Interface{
	
	public void returnToMainMenu() {
		System.out.println("\nreturning to main menu\n");
		start();
	}
	
	public void start() {
		if (calendars.isEmpty()) displayWelcomeHeader();
		
		displayOptions();
		
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
			boolean stayInLoop = true;
			while (stayInLoop) {
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
