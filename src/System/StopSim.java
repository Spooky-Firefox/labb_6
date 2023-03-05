package System;

public class StopSim extends Event {
	public StopSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String toString() {
		return "Stop";
	}

	@Override
	public void execute(State state) {
		state.stop();
	}
}
