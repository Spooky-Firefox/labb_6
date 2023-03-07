package Controller;

public abstract class Event {
	private double startTime;
	private EventQueue queue;

	public Event(double time, EventQueue eventQueue) {
		this.queue = eventQueue;
		this.startTime = time;
	}

	public double getStartTime(){
		return this.startTime;
	}

	public String prettyStartTime() {
		// Source, formatting rules:
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		return String.format("%6.2f", this.startTime);
	}

	public String prettyName() {
		// Left padd the string until it's 9 letters long
		// (9 is the size of the longest event name Betalning)
		return String.format("%9s", this.toString());
	}

	public EventQueue getQueue() {
		return queue;
	}

	public void execute(State state) {
		state.setTime(this.getStartTime());
		state.notifyView(this);
	}
}
