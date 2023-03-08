package Controller;

/**
 * Event is an abstract class that all events should inherit from, to be run inside
 * the simulator loop.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public abstract class Event {
	private double startTime;
	private EventQueue queue;

	/**
	 * Constructor.
	 * @param time time when the event will be run
	 * @param eventQueue an instance of EventQueue which tracks all events
	 */
	public Event(double time, EventQueue eventQueue) {
		this.queue = eventQueue;
		this.startTime = time;
	}

	/**
	 * Return the time when the event will be started.
	 * @return the start time
	 */
	public double getStartTime(){
		return this.startTime;
	}

	/**
	 * Returns a the start time but nicely formatted, suitable for output.
	 * @return the start time but string formatted
	 */
	public String prettyStartTime() {
		// Source, formatting rules:
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		return String.format("%6.2f", this.startTime);
	}

	/**
	 * Returns the name of the event.
	 * @return name of event
	 */
	public String prettyName() {
		// Left padd the string until it's 9 letters long
		// (9 is the size of the longest event name Betalning)
		return String.format("%9s", this.toString());
	}

	/**
	 * Returns the EventQueue this event is part of.
	 * @return instance of EventQueue
	 */
	public EventQueue getQueue() {
		return queue;
	}

	/**
	 * Method all other events should override with their own actions to be done when
	 * the event is being run. Don't forget to call this method beforehand,
	 * using super.execute().
	 * @param state instance of State
	 */
	public void execute(State state) {
		state.setTime(this.getStartTime());
		state.notifyView(this);
	}
}
