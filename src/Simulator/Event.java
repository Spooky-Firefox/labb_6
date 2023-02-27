package Simulator;

import Simulator.EventQueue;
public abstract class Event{
	private int startTime;
	private EventQueue queue;
	
	public Event(int time, EventQueue eventQueue) {
		this.queue = eventQueue;
		this.startTime = time;
	}
	
	public void execute(State state)
	{
		this.addEvent();
	}
}
