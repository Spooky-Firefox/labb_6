package Controller;

public class StartSim extends Event {
	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String toString() {
		return "Start";
	}

	@Override
	public void execute(State state) {
		// Do nothing
	}
}
