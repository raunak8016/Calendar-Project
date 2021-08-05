package models;
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
	 * @param events
	 * @param scheduleYear
	 * @param scheduleMonth
	 * @param scheduleDay
	 */
	public Schedule(ArrayList<Event> events, int scheduleYear,
					int scheduleMonth, int scheduleDay) {
		this.setEvents(events);
		this.setScheduleYear(scheduleYear);
		this.setScheduleMonth(scheduleMonth);
		this.setScheduleDay(scheduleDay);
	}
	
	/**
	 * Constructor creates an instance of Schedule
	 * with just the date.
	 * 
	 * @param setYear
	 * @param setMonth
	 * @param setDay
	 */
	public Schedule(int scheduleYear, int scheduleMonth, int scheduleDay) {
		this.setScheduleYear(scheduleYear);
		this.setScheduleMonth(scheduleMonth);
		this.setScheduleDay(scheduleDay);
	}
	
	/**
	 * Constructor creates an instance of Schedule
	 * with only the year and the month being
	 * assigned.
	 * 
	 * @param scheduleYear
	 * @param scheduleMonth
	 */
	public Schedule(int scheduleYear, int scheduleMonth) {
		this.setScheduleYear(scheduleYear);
		this.setScheduleMonth(scheduleMonth);
	}
	
	// method needs to be implemented to see if the year is a leap year
	
	/**
	 * @param scheduleDay for the Schedule Object
	 */
	public void setScheduleDay(int scheduleDay) {
		int numOfDays = Month.valueOf(this.scheduleMonth).length(false);
		if (scheduleDay <= numOfDays) {
			this.scheduleDay = scheduleDay;
		}
		else {
			System.out.printf("Schedule day value has to be between 1"
							+ "and %s days for the month of %s",
							numOfDays, this.scheduleMonth);
		}
	}
	
	/*
	 * There is a privacy leak in this function
	 * that needs to be fixed.
	 */
	
	/**
	 * @param events the events to set
	 */
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
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
	public int getScheduleYear() {
		return this.scheduleYear;
	}

	/**
	 * @param scheduleYear the scheduleYear to set
	 */
	public void setScheduleYear(int scheduleYear) {
		if (scheduleYear >= 2000 && scheduleYear <= 3000) {
			this.scheduleYear = scheduleYear;
		}
	}
	
	/**
	 * @param scheduleMonth is the month of the Schedule object/instance.
	 */
	public void setScheduleMonth(int scheduleMonth) {
		if (scheduleMonth >= 1 && scheduleMonth <= 12) {
			this.scheduleMonth = Month.of(scheduleMonth).toString();
		}
	}
	
	/**
	 * @return the scheduleDay
	 */
	public String getScheduleMonth() {
		String scheduleMonthCopy = new String(scheduleMonth);
		return scheduleMonthCopy;
	}
	
	/**
	 * @return the scheduleDay
	 */
	public int getScheduleDay() {
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
		if (year == getScheduleYear() && month.equals(scheduleMonth) && day == scheduleDay)
			this.getEvents().add(eventToAdd);
	}
	
	/**
	 * @return String visualization of schedule 
	 */
	public String scheduleVisualizer() {
		if (this.getEvents().isEmpty()) {
			return "There are no events scheduled here.";
		}
		String scheduleVisualization = "";
		for (int i = 0; i < this.getEvents().size(); i++) {
			System.out.println("");
			scheduleVisualization = scheduleVisualization + this.getEvents().get(i).toString() + " \n";
		}
		return scheduleVisualization;
	}
	
}