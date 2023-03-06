package Controller;

public class StopSim extends Event {
	public StopSim(double time, EventQueue eventQueue) {
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
