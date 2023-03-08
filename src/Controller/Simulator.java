package Controller;

/**
 * A machine that picks out events and runs them, one at a time.
 * It will run until it's stopped or run out of events.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class Simulator {
	private State state;
	private EventQueue events;

	/**
	 * Constructor.
	 * @param state instance of State
	 * @param events instance of EventQueue
	 */
	public Simulator(State state, EventQueue events) {
		this.state = state;
		this.events = events;
	}

	/**
	 * Starts the simulator. It will run events until it's stopped or run out of events.
	 */
	public void runLoop() {
		while (events.hasNext()){
			if (state.isStopped()) {
				System.out.println("Simulation: STOPPED");
				return;
			}
			events.nextEvent().execute(state);
		}
	}
}
