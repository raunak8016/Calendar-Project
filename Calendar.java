import java.time.LocalDate;
import java.time.YearMonth;

public class Calendar {
	private int year;
	private int month;
	
	public Calendar(int year, int month) {
		if(year>=0 && year<= 3000) this.year= year;
		else System.out.println("Error");
		if (month>=1 && month<=12) this.month = month;
		else System.out.println("Error");
	}
	
	public void printMonth() {
        YearMonth ym = YearMonth.of(year, month);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int counter = 1;
        //some code and structure implemented from https://stackoverflow.com/questions/35679827/how-to-display-calendar-in-java
        // Get day of week of 1st date of the month and print space for as many days as
        // distant from SUN
        int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        if (dayValue != 7)
            for (int i = 0; i < dayValue; i++, counter++) {
                System.out.printf("%-4s", "");
            }

        for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
            System.out.printf("%-4d", i);

            // Break the line if the value of the counter is multiple of 7
            if (counter % 7 == 0) {
                System.out.println();
            }
        }
    }
}