import java.time.Month;
import java.util.ArrayList;

/**
 * 
 * @author raunak+sidd
 * 
 */

public class Schedule {
	//initialize variables
	private ArrayList<Event> events = new ArrayList<Event>();
	private int scheduleYear;
	private String scheduleMonth;
	private int scheduleDay;
	
	//create constructor
	public Schedule(ArrayList<Event> setEvents, int setYear, int setMonth, int setDay) {
		events = setEvents;
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
		scheduleDay = setDay;
	}
	
	public Schedule(int setYear, int setMonth, int setDay) {
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
		scheduleDay = setDay;
	}
	
	public Schedule(int setYear, int setMonth) {
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
	}
	
	/**
	 * @return events as an ArrayList
	 */
	public ArrayList<Event> getEvents() {
		return events;
	}
	
	/**
	 * @return the scheduleYear
	 */
	public int getYear() {
		return scheduleYear;
	}
	
	
	/**
	 * @return the scheduleDay
	 */
	public int getDay() {
		return scheduleDay;
	}
	
	/**
	 * @param eventToAdd to events
	 */
	public void addEvent(Event eventToAdd) {
		int year = eventToAdd.getEventYear();
		String month = eventToAdd.getEventMonth();
		int day = eventToAdd.getEventDay();
		// Checks eventToAdd variables to see if event can be added to schedule
		if (year == scheduleYear && month.equals(scheduleMonth) && day == scheduleDay) events.add(eventToAdd);
//		else System.out.println(String.format("Error: event attribute of '%s' doesn't match with those of Schedule instance.", eventToAdd.getEventName()));
	}
	
	/**
	 * @return String visualization of schedule
	 */
	public String scheduleVisualizer() {
		String ret = "";
		for (int i = 0; i < events.size(); i++) {
			ret += events.get(i).toString() + " \n";
		}
		return ret;
	}
	
	// test
	public static void main(String[] args) {
		double[] timeFrameOne = {10.00, 15.25};
		double[] timeFrameTwo = {16.00, 19.00};
		Event completeTest = new Event("complete test", 2, 2, 2020, timeFrameOne);
		Event askForGrades = new Event("ask for grades", 2, 3, 2020, timeFrameTwo);
		Schedule schedule1 = new Schedule(2020, 2, 2);
		schedule1.addEvent(completeTest);
		schedule1.addEvent(askForGrades);
		System.out.println(schedule1.scheduleVisualizer());
	}
}
