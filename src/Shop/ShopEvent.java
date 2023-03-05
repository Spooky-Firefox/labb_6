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
		((ShopState) state).updateStatistics();
		this.execute((ShopState) state);
	}

	abstract void execute(ShopState state);
}
