package Controller;

/**
 * The first event to be run by the simulator.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class StartSim extends Event {
	/**
	 * Constructor.
	 * @param time the start time for the event
	 * @param eventQueue instance of EventQueue the event belongs to
	 */
	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	/**
	 * Returns the name of the event.
	 * @return name of event
	 */
	public String toString() {
		return "Start";
	}

	/**
	 * Overrides inherited method from Event. It does nothing.
	 * @param state instance of current State
	 */
	public void execute(State state) {
		super.execute(state);
	}
}
