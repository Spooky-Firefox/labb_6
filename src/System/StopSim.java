package System;

public class StopSim extends Event {
	public StopSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
		state.stop();
	}
}
