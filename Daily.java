import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
 
public class Daily {
	public static void main(String[] args) throws ParseException {
		 System.out.println("Please enter the date (format: 2020-12-17):");
		Scanner scanner = new Scanner(System.in);    
		 String str = scanner.nextLine(); //Enter the date to be queried
		
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //Create time object
		 Date date = df.parse(str); //The string is converted into a time object
		 Calendar c = new GregorianCalendar(); //Create date object
		 c.setTime(date); //The time object is converted to a date class
		
		 int day = c.get(Calendar.DAY_OF_MONTH); //The month number of the query is assigned to day, and the number will be used when *marked below
		 int days = c.getActualMaximum(Calendar.DATE); //How many talent values ​​are given to days in the month
		
		 System.out.println("Day\t1\t2\t3\t4\t5\t "); //Print the header of the weekday
		
		 c.set(Calendar.DAY_OF_MONTH,1); //First set the date c to the 1st of each month
		
		 for (int i = 0; i <c.get(Calendar.DAY_OF_WEEK)-1; i++) {//Find and output tab characters, the 1st of the month is the day of the week
			System.out.print("\t");	
		}
		
		
		
		for (int i = 1; i <= days; i++) {                 
			 if(day == c.get(Calendar.DAY_OF_MONTH)) {//Circularly output each day of the month, which is the date label of the query*
				System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
			}else {
				System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
			}
			
			 if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {//If the number is the last day of Saturday, wrap
				 System.out.println(); //New line
			}
			
			 c.add(Calendar.DAY_OF_MONTH,1); //Move back one day each time
		}	
		
	}
}
