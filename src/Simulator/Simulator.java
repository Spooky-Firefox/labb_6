package Simulator;


public class Simulator {
	private State state;
	private EventQueue events;

	public Simulator(State state, EventQueue events) {
		this.state = state;
		this.events = events;
	}

	public void RunLoop() {
		while(state.isStopped() == false) {
			events.nextEvent().execute(state);
			if (!events.hasNext()) {
				System.out.println("event was null");
				state.stop();
			}
		}
	}
}
