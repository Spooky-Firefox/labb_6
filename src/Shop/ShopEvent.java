package Shop;

import Controller.Event;
import Controller.EventQueue;
import Controller.State;

public abstract class ShopEvent extends Event {
	protected int customer;

	public ShopEvent(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String prettyCustomer() {
		// Stupid rule from pg. 9, task 3.
		if (this.customer == -1) {
			return "---";
		}
		// Source, formatting rules:
		// https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		return String.format("%2d", this.customer);
	}

	@Override
	final public void execute(State state) {
		// TODO: ensure it's really a ShopState?
		ShopState st = (ShopState) state;
		st.updateStatistics();
		state.notify(this);

		this.execute(st);
	}

	// NOTE: This func is automagically run by the general execute(State) above,
	// inside Simulator.runLoop(), so there's no need to call super() in this func!
	abstract void execute(ShopState state);
}
