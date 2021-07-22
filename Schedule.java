/**
 * 
 * @author raunak+sidd
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
		events = setEvents;
		scheduleYear = setYear;
		scheduleDay = setDay;
	}
	
	public Schedule(int setYear, int setDay) {
		scheduleYear = setYear;
		scheduleDay = setDay;
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
		Event askForGrades = new Event("ask for grades", 2, 2, 2020, timeFrameTwo);
		ArrayList<Event> eventList = new ArrayList<Event>();
		eventList.add(completeTest);
		eventList.add(askForGrades);
		Schedule schedule1 = new Schedule(eventList, 2020, 2);
		System.out.println(schedule1.scheduleVisualizer());
	}
	
}
