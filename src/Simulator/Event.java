package Simulator;

public abstract class Event{
	private int startTime;
	private EventQueue queue;

	public Event(int time, EventQueue eventQueue) {
		this.queue = eventQueue;
		this.startTime = time;
        eventQueue.addEvent(this);
	}

	public abstract void execute(State state);
}
