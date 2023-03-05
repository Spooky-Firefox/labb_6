package System;

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
		return String.format("%6.2f", this.startTime);
	}

    public EventQueue getQueue() {
    	return queue;
    }

    public abstract void execute(State state);
}
