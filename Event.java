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
	private double length;
	private double[] eventTimeFrame = new double[] {0.00, 24.00};

	public Event(String eventName, int eventDay, int eventMonth, int eventYear, double[] eventTimeFrame) {
		this.eventName = eventName;
		this.eventYear = eventYear;
		this.eventMonth = Month.of(eventMonth).toString();
		this.eventDay = eventDay;
		if (eventTimeFrame[0] < eventTimeFrame[1]) {
			if (eventTimeFrame[0] >= 0.0 && eventTimeFrame[1] < 24.0) {
				this.eventTimeFrame = eventTimeFrame;
				this.setLength(eventTimeFrame[1]-eventTimeFrame[0]);
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
	
	//did not end up implementing this method
	//could be used as an additional feature in the future so will leave code
	public String timeFrameToString() {
		String first = "";
		String second = "PM";
		
		int startHour = (int) eventTimeFrame[0];
		int startMin = (int) ((eventTimeFrame[0] - (startHour)) * 60);
		
		int endHour = (int) eventTimeFrame[1];
		int endMin = (int) ((eventTimeFrame[1] - endHour) * 60);
		
		String startTime;
		
		String newStartMin = Integer.toString(startMin);
		String newEndMin = Integer.toString(endMin);
		
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

		String endTime = String.format("%s:%s %s", endHour, newEndMin, second);
		
		return String.format("%s - %s", startTime, endTime);
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set in hours
	 */
	public void setLength(double length) {
		this.length = length;
		eventTimeFrame[1] = eventTimeFrame[0] + length;
	}

	
	// toString() method. 
	
	public String toString() {
		return String.format("%s scheduled on %s %s %s", eventName, dateToString(), "@", timeFrameToString());
	}
	
}