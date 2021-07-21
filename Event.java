/**
 * 
 * @author Sidd
 *
 */

public class Event {
	private String eventName;
	String unitPrecision;
	int[] span;
	
	public Event(String eventName, int eventYear, int eventMonth, int eventDay) {
		this.eventName = eventName;
	}
	
	public Event(String eventName, int eventYear, int eventDay, double[] eventTimeFrame) {
		this.eventName = eventName;
	}
	
	// toString() method.

	public String toString() {
		return String.format("");
	}
	
}
