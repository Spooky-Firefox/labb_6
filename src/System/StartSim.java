package System;

import Shop.Arrival;

public class StartSim extends Event {

	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
		Arrival arrival = new Arrival(super.getStartTime() + 1, super.getQueue());
		super.getQueue().addEvent(arrival);
	}
}
