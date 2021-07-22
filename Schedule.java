import java.time.Month;
import java.util.ArrayList;

/**
 * 
 * @author raunak
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
		if (year == scheduleYear && month.equals(scheduleMonth) && day == scheduleDay) this.events.add(eventToAdd);
//		else System.out.println(String.format("Error: event attribute of '%s' doesn't match with those of Schedule instance.", eventToAdd.getEventName()));
	}
	
	/**
	 * @return String visualization of schedule 
	 */
	public String scheduleVisualizer() {
		String ret = "";
		for (int i = 0; i < this.getEvents().size(); i++) {
			ret = ret+ this.getEvents().get(i).toString() + " \n";
		}
		return ret;
	}
	
}