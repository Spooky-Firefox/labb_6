package System;

public abstract class Event {
    private int startTime;
    private EventQueue queue;

    public Event(int time, EventQueue eventQueue) {
        this.queue = eventQueue;
        this.startTime = time;
    }

    public int getStartTime(){
        return startTime;
    }

    public EventQueue getQueue() {
    	return queue;
    }

    public abstract void execute(State state);
}
