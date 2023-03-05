package System;

public class StartSim extends Event {
	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
		// Do nothing
	}
}
