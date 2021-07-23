import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 * 
 * @author raunak
 *
 */

public class Calendar {
	ArrayList<Schedule> schedules = new ArrayList<Schedule>();
	private int year;
	private int month;
	
	/**
	 * Constructor for Calendar object which
	 * takes year and month as instance
	 * variables.
	 * 
	 * @param year the year of the Calendar object
	 * @param month the month of the Calendar object
	 */
	public Calendar(int year, int month) {
		// Ensures valid values for year.
		if(year >= 0 && year <= 3000)
			this.year= year;
		else
			System.out.println("Error");
		// Ensures valid values for month.
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			System.out.println("Error");
	}
	
	/**
     * Code and structure implemented from 
     * https://stackoverflow.com/questions/
     * 35679827/how-to-display-calendar-in-java
     */
	public void printMonth() {
        YearMonth ym = YearMonth.of(year, month);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int counter = 1;
        
        /*
         * Gets day of the week of 1st date of the
         * month and print space for as many days
         * in a week for the month.
         */
        int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        if (dayValue != 7)
            for (int i = 0; i < dayValue; i++, counter++) {
                System.out.printf("%-4s", "");
            }

        for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
            System.out.printf("%-4d", i);

            // Breaks the line if the value of the counter is a multiple of 7.
            if (counter % 7 == 0) {
                System.out.println();
            }
        }
    }
	
	/**
	 * @return the schedule within the calendar which has the
	 * same month and year, but was not constructed with a
	 * day value.
	 */
	public Schedule accessScheduleForUser(){
		for (Schedule schedule : schedules) {
			if (schedule.getYear() == year && schedule.getMonth().equals(Month.of(month).toString()) && schedule.getDay() == 0) {
				return schedule;
			}
		}
		return new Schedule(year, month);
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Static method which returns a String object that
	 * is formatted for navigating through a HashMap
	 * by String key value. Takes year and month values
	 * as arguments instead of using instance variable
	 * values.
	 * 
	 * @param year is the year of the Calendar instance.
	 * @param month is the month of the Calendar instance.
	 * @return formatted string for HashMap navigation.
	 */
	public static String toKeyFormattedString(int year, int month) {
		return String.format("%s %s", year, Month.of(month).toString());
	}
	
	public String toString() {
		return String.format("%s %s", year, Month.of(month).toString());
	}
}