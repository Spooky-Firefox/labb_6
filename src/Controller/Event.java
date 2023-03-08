package Controller;

/**
 * an event that can happen, and may change the given sate, and/or add new events to EventQueue
 * @author Olle Ronstad
 */
public abstract class Event {
	private double startTime;
	private EventQueue queue;

	/**
	 * Creates an event scheduled to execute att time, with a reference to que so that new events can be added during
	 * execution
	 * @param time the time the event should execute
	 * @param eventQueue reference to queue for ability to add new events
	 */
	public Event(double time, EventQueue eventQueue) {
		this.queue = eventQueue;
		this.startTime = time;
	}

	/**
	 * Returns the time of which the event is scheduled to execute
	 * @return the time of which the event is scheduled to execute
	 */
	public double getStartTime(){
		return this.startTime;
	}

	/**
	 * Returns a formatted string of the start time equivalent to "%6.2f"
	 * @return formatted string
	 */
	public String prettyStartTime() {
		// Source, formatting rules:
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		return String.format("%6.2f", this.startTime);
	}

	/**
	 * Returns a formatted string of the toString method, equivalent to "%9s"
	 * @return formatted string
	 */
	public String prettyName() {
		// Left padd the string until it's 9 letters long
		// (9 is the size of the longest event name Betalning)
		return String.format("%9s", this.toString());
	}

	/**
	 * return the objects accosted event queue used for adding new events
	 * @return the objects accosted event queue
	 */
	public EventQueue getQueue() {
		return queue;
	}

	/**
	 * Executes the event, may state event and add new events
	 * @param state the state
	 */
	public void execute(State state) {
		state.setTime(this.getStartTime());
		state.notifyView(this);
	}
}
