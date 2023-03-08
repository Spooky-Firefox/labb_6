package Shop;

import Controller.Event;
import Controller.EventQueue;
import Controller.State;

/**
 * Abstract class that extends Event, used for creating new shop events.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
abstract class ShopEvent extends Event {
	/**
	 * Ties a customer to the event.
	 */
	protected int customer;

	ShopEvent(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	String prettyCustomer() {
		// Stupid rule from pg. 9, task 3.
		if (this.customer == -1) {
			return "---";
		}
		// Source, formatting rules:
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		return String.format("%2d", this.customer);
	}

	/**
	 * Overrides the inherited method from Event, which is run by the simulator.
	 * @param state an instance of State
	 */
	@Override
	final public void execute(State state) {
		ShopState st = (ShopState) state;
		// Have to update time before updating stats
		state.setTime(this.getStartTime());
		st.updateStatistics();
		// and can only print output after stats was updated
		state.notifyView(this);
		this.execute(st);
	}

	// NOTE: This func is automagically run by the general execute(State) above,
	// inside Simulator.runLoop(), so there's no need to call super() in this func!
	abstract void execute(ShopState state);
}
