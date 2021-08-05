package models;
import java.time.Month;

/**
 * 
 * @author Sidd
 *
 */

public class Event {
	private String eventName;
	private int eventYear;
	private String eventMonth;
	private int eventDay;
	private double[] eventTimeFrame;

	/**
	 * Constructor creates an instance of Event with
	 * event date information as well as the time
	 * frame of the event.
	 * 
	 * @param eventName assigns eventName.
	 * @param eventDay assigns eventDay.
	 * @param eventMonth assigns eventMonth as String value based on Month index.
	 * @param eventYear assigns eventYear.
	 * @param eventTimeFrame assigns TimeFrame.
	 */
	public Event(String eventName, int eventDay, int eventMonth, int eventYear, double[] eventTimeFrame) {
		this.eventName = eventName;
		this.eventYear = eventYear;
		this.eventMonth = Month.of(eventMonth).toString();
		this.eventDay = eventDay;
		// Ensures valid values for eventTimeFrame
		if (eventTimeFrame[0] < eventTimeFrame[1])
			if (eventTimeFrame[0] >= 0.0 && eventTimeFrame[1] < 24.0)
				this.eventTimeFrame = eventTimeFrame;
	}
	
	/**
	 * Constructor creates a new instance of Event
	 * by copying all attribute values of another
	 * instance
	 * 
	 * @param eventToCopy the Event instanceo of
	 * which to copy the instance variable values
	 */
	public Event(Event eventToCopy) {
		this.eventName = eventToCopy.getEventName();
		this.eventYear =  eventToCopy.getEventYear();
		this.eventMonth = eventToCopy.getEventMonth();
		this.eventDay = eventToCopy.getEventDay();
	}

	// Getter and setter methods for eventName.
	
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	// Getter and setter methods for eventYear.
	
	/**
	 * @return the eventYear
	 */
	public int getEventYear() {
		return eventYear;
	}
	
	/**
	 * @param eventYear the eventYear to set
	 */
	public void setEventYear(int eventYear) {
		this.eventYear = eventYear;
	}
	
	// Getter and setter methods for eventMonth.
	
	/**
	 * @return the eventMonth
	 */
	public String getEventMonth() {
		return eventMonth;
	}

	/**
	 * @param eventMonth the eventMonth to set
	 */
	public void setEventMonth(int eventMonth) {
		this.eventMonth = Month.of(eventMonth).toString();
	}

	/**
	 * @return the eventDay
	 */
	public int getEventDay() {
		return eventDay;
	}
	
	/**
	 * @param eventDay the eventDay to set
	 */
	public void setEventDay(int eventDay) {
		this.eventDay = eventDay;
	}
	
	// Getter and setter methods for eventTimeFrame.
	
	/**
	 * @return the eventTimeFrame
	 */
	public double[] getEventTimeFrame() {
		return eventTimeFrame;
	}

	/**
	 * @param eventTimeFrame the eventTimeFrame to set
	 */
	public void setEventTimeFrame(double[] eventTimeFrame) {
		this.eventTimeFrame = eventTimeFrame;
	}
	
	/**
	 * @return event date in String form
	 */
	public String dateToString() {
		return String.format("%s %s, %s", eventMonth, eventDay, eventYear);
	}
	
	/**
	 * @return
	 */
	public String setTimeFormat() {
		return eventMonth;
	}
	
	/**
	 * @return eventTimeFrame as String in 12 hour format
	 */
	public String timeFrameToString() {
		String first = "";
		String second = "PM";
		// Event start.
		int startHour = (int) eventTimeFrame[0];
		int startMin = (int) ((eventTimeFrame[0] - (startHour)) * 100);
		// Event end.
		int endHour = (int) eventTimeFrame[1];
		int endMin = (int) ((eventTimeFrame[1] - endHour) * 100);
		// Start of timeFrame as String
		String startTime;
		// Reassigned values to be added into formatted String
		String newStartMin = Integer.toString(startMin);
		String newEndMin = Integer.toString(endMin);
		/*
		 * Sets conditional for formatting into hours
		 * and minutes as well as adding AM/PM formatting
		 * based on starting and ending time of Event
		 * instance
		 */
		if ((eventTimeFrame[0] > 12) && (eventTimeFrame[1] > 12)) {
			startHour -= 12;
			endHour -= 12;
			if (startMin == 0 || startMin < 10) {
				newStartMin = "0" + newStartMin;
			}
			startTime = String.format("%s:%s", startHour, newStartMin);
		}
		else if ((eventTimeFrame[0] < 12) && (eventTimeFrame[1] < 12)) {
			second = "AM";
			if (startMin == 0 || startMin < 10) {
				newStartMin = "0" + newStartMin;
			}
			startTime = String.format("%s:%s", startHour, newStartMin);
		} else {
			first = "AM";
			if (startMin == 0 || startMin < 10) {
				newStartMin = "0" + newStartMin;
			}
			endHour -= 12;
			startTime = String.format("%s:%s %s", startHour, newStartMin, first);
		}
		if (endMin == 0 || endMin < 10) {
			newEndMin = "0" + newEndMin;
		}
		// endTime formatted
		String endTime = String.format("%s:%s %s", endHour, newEndMin, second);
		
		return String.format("%s - %s", startTime, endTime);
	}

	// toString() method
	public String toString() {
		return String.format("%s scheduled on %s %s %s", eventName, dateToString(), "@", timeFrameToString());
	}
	
}