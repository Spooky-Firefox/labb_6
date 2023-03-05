package Shop;

import System.Event;
import System.EventQueue;
import System.State;

public abstract class ShopEvent extends Event {
	public int customersNumber;

	public ShopEvent(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	final public void execute(State state) {
		// TODO: ensure it's really a ShopState?
		ShopState st = (ShopState) state;
		st.updateStatistics();
		this.execute(st);
	}

	abstract void execute(ShopState state);
}
