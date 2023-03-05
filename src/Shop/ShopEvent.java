package Shop;

import System.Event;
import System.EventQueue;
import System.State;

public abstract class ShopEvent extends Event {
	private int customer;

	public ShopEvent(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public int getCustomer() {
		return this.customer;
	}

	public String prettyCustomer() {
		// Stupid rule from pg. 9, task 3.
		if (this.customer == -1) {
			return "---";
		}
		return String.format("%2d", this.customer);
	}

	@Override
	final public void execute(State state) {
		// TODO: ensure it's really a ShopState?
		ShopState st = (ShopState) state;
		st.updateStatistics();
		this.execute(st);
	}

	// NOTE: This func is automagically run by the general execute(State) above,
	// inside Simulator.runLoop(), so there's no need to call super() in this func!
	abstract void execute(ShopState state);
}
