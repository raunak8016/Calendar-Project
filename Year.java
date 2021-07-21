import java.util.HashMap;

/**
 * 
 * @author Sidd
 *
 */

public class Year {
	int yearNumber;
	boolean isLeapYear;
	int yearCode;
	HashMap<String, Month> months;
	
	// array of month names which has constant value
	final String[] monthNames = {
			"January", "February", "March", 
			"April","May", "June", 
			"July", "August","September", 
			"October", "November", "December"
			};
	
	public Year() {
		yearNumber = 1970;
		determineIfLeapYear();
		assignMonths();
	}

	public Year(int yearNumber) {
		this.yearNumber = yearNumber;
		determineIfLeapYear();
		assignMonths();
	}

	private void determineIfLeapYear() {
		if ((yearNumber % 100) % 4 == 0) {
			isLeapYear = true;
			if (yearNumber % 100 == 0) {
				if (yearNumber % 400 != 0) {
					isLeapYear = true;
				}
			}
		}
		else {
			isLeapYear = false;
		}
	}
	
	private void assignMonths() {
		int[] monthValues = {28, 30, 31};
		if (isLeapYear) {
			monthValues[0] = 29;
		}
		for (int month = 0; month < 12; month++) {
			String name = monthNames[month];
			int numberOfDays = monthValues[0];
			if ((month % 2 == 0 && month <= 6) || (month % 2 == 1 && month > 6)) {
				numberOfDays = monthValues[2];
			}
			else if ((month % 2 == 1 && month <= 6) || (month % 2 == 0 && month > 6)) {
				numberOfDays = monthValues[1];
			}
			months.put(name, new Month(name, numberOfDays));
		}
	}
	
}
