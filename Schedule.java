/**
 * 
 * @author rauna
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
	
	//getter methods for variables
	public ArrayList<Event> getEvents() {
		return events;
	}
	public int getYear() {
		return scheduleYear;
	}
	public int getDay() {
		return scheduleDay;
	}
	//add events method
	public void addEvent(Event eventToAdd) {
		events.add(eventToAdd);
	}
	
	//create visualization method
	public String ScheduleVisualizer() {
		String ret = "";
		for (int i = 0; i<=events.size(); i++) {
			ret = ret+ events.get(i).toString();
		}
		return ret;
	}
	
}
