package Controller;

/**
 * The last event to be run by the simulator.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class StopSim extends Event {
	/**
	 * Constructor.
	 * @param time the start time for the event
	 * @param eventQueue an instance of EventQueue
	 */
	public StopSim(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	/**
	 * Returns the name of the event.
	 * @return name of event
	 */
	public String toString() {
		return "Stop";
	}

	/**
	 * Overrides inherited method from Event. It stops the simulation.
	 * @param state instance of current State
	 */
	public void execute(State state) {
		super.execute(state);
		state.stop();
	}
}
