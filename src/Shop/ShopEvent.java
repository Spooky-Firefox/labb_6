package Shop;

import Simulator.Event;
import Simulator.EventQueue;
import Simulator.State;

public abstract class ShopEvent extends Event {
	public int customersNumber;

	public ShopEvent(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}
}
