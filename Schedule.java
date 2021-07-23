import java.time.Month;
import java.util.ArrayList;

/**
 * 
 * @author Sidd
 * 
 */

public class Schedule {
	private ArrayList<Event> events = new ArrayList<Event>();
	private int scheduleYear;
	private String scheduleMonth;
	private int scheduleDay;
	
	/**
	 * Constructor creates an instance of Schedule
	 * with ArrayList instance of events and
	 * date to place schedule on the Calendar.
	 * 
	 * @param setEvents
	 * @param setYear
	 * @param setMonth
	 * @param setDay
	 */
	public Schedule(ArrayList<Event> setEvents, int setYear, int setMonth, int setDay) {
		events = setEvents;
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
		scheduleDay = setDay;
	}
	
	/**
	 * Constructor creates an instance of Schedule
	 * with just the date.
	 * 
	 * @param setYear
	 * @param setMonth
	 * @param setDay
	 */
	public Schedule(int setYear, int setMonth, int setDay) {
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
		scheduleDay = setDay;
	}
	
	/**
	 * Constructor creates an instance of Schedule
	 * with only the year and the month being
	 * assigned.
	 * 
	 * @param setYear
	 * @param setMonth
	 */
	public Schedule(int setYear, int setMonth) {
		scheduleYear = setYear;
		scheduleMonth = Month.of(setMonth).toString();
	}
	
	/**
	 * @return events as an ArrayList
	 */
	public ArrayList<Event> getEvents() {
		/*ArrayList<Event> newEventList = new ArrayList<Event>();
		for (Event event : this.events) {
			newEventList.add(event);
		}*/ //why do we have this, it screws up schedule menu
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
	public String getMonth() {
		String scheduleMonthCopy = new String(scheduleMonth);
		return scheduleMonthCopy;
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
		/*
		 *  Adds eventToAdd only if the values
		 *  match those of the Schedule instance.
		 */
		if (year == scheduleYear && month.equals(scheduleMonth) && day == scheduleDay)
			this.events.add(eventToAdd);
	}
	
	/**
	 * @return String visualization of schedule 
	 */
	public String scheduleVisualizer() {
		if (this.getEvents().isEmpty()) {
			return "There are no events scheduled here.";
		}
		String ret = "";
		for (int i = 0; i < this.getEvents().size(); i++) {
			ret = ret + this.getEvents().get(i).toString() + " \n";
		}
		return ret;
	}
	
}