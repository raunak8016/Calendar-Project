/**
 * 
 * @author raunak
 * 
 */

import java.util.ArrayList;

public class Schedule {
	//initialize variables
	private ArrayList<Event> events = new ArrayList<Event>();
	private int scheduleYear;
	private int scheduleDay;
	
	//create constructor
	public Schedule(ArrayList<Event> setEvents, int setYear, int setDay) {
		events=setEvents;
		scheduleYear=setYear;
		scheduleDay=setDay;
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
		int day = eventToAdd.getEventDay();
		// Checks eventToAdd variables to see if event can be added to schedule
		if (year == scheduleYear && day == scheduleDay) events.add(eventToAdd);
		else System.out.println("Error: event attributes don't match with those of schedule.");
	}
	
	/**
	 * @return String visualization of schedule
	 */
	public String ScheduleVisualizer() {
		String ret = "";
		for (int i = 0; i<=events.size(); i++) {
			ret = ret + events.get(i).toString();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
	}
	
}
