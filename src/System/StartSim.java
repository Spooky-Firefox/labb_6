package System;

import Shop.EventArrival;

public class StartSim extends Event {

	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
		EventArrival arrival = new EventArrival(super.getStartTime() + 1, super.getQueue());
		super.getQueue().addEvent(arrival);
	}
}
