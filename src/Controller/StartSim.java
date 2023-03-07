package Controller;

public class StartSim extends Event {
	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String toString() {
		return "Start";
	}

	public void execute(State state) {
		super.execute(state);
	}
}
