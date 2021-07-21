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
			System.out.print("Would you like to add an event on a certain day?");
			String hio = myObj.nextLine();
			
		}
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppRunner calendar1 = new AppRunner();
		calendar1.run();
		

	}

}
