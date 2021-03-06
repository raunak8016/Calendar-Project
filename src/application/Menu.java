package application;

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
			/*
			 * While loop keeps running to return the user back to
			 * the same starting menu, while keeping information in
			 * the interface.
			 */
			while (stayInLoop) {
				String input = userInput.nextLine();
				switch (input) {
					case "create":
						addCalendar();
						returnToMainMenu();
						break;
					case "view":
						viewCalendar();
						returnToMainMenu();
						break;
					case "schedule":
						scheduleEventForUser();
						returnToMainMenu();
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
