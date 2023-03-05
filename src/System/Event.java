package System;

public abstract class Event {
	// TODO: use double instead
    private int startTime;
    private EventQueue queue;

    public Event(int time, EventQueue eventQueue) {
        this.queue = eventQueue;
        this.startTime = time;
    }

    public int getStartTime(){
        return startTime;
    }

    public String prettyStartTime() {
		// TODO: pretty printed time (for use in View)
		return "-1";
	}

    public EventQueue getQueue() {
    	return queue;
    }

    public abstract void execute(State state);
}
