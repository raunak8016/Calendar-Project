/**
 * 
 * @author Sidd
 *
 */

public class Event {
	private String eventName;
	private int eventYear;
	private int eventMonth;
	private int eventDay;
	private double[] eventTimeFrame = new double[] {0.0, 24.0};
	
	public Event(String eventName, int eventYear, int eventDay) {
		this.eventName = eventName;
		this.eventYear = eventYear;
		this.eventDay = eventDay;
	}
	
	public Event(String eventName, int eventYear, int eventDay, double[] eventTimeFrame) {
		this.eventName = eventName;
		this.eventYear = eventYear;
		this.eventDay = eventDay;
		if (eventTimeFrame[0] < eventTimeFrame[1] && eventTimeFrame.length == 2) {
			if (eventTimeFrame[0] >= 0.0 && eventTimeFrame[1] <= 24.0) {
				this.eventTimeFrame = eventTimeFrame;
			}
		}
	}

	// Getter and setter methods for eventName.
	
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * @return the eventName
	 */
	public Event[] getEventNamesByName(String name) {
		return new Event[0];
	}
	
	/**
	 * @return the eventName
	 */
	public Event[] getEventNamesByDate(String date) {
		return new Event[0];
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
	
	// Getter and setter methods for eventDay.
	
	/**
	 * @return the eventMonth
	 */
	public int getEventMonth() {
		return eventMonth;
	}

	/**
	 * @param eventMonth the eventMonth to set
	 */
	public void setEventMonth(int eventMonth) {
		this.eventMonth = eventMonth;
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
	
	// toString() method.

	public String toString() {
		return String.format("");
	}
	
}
