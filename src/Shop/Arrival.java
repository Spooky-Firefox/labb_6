package Shop;

import Simulator.EventQueue;
import Simulator.State;

public class Arrival extends ShopEvent {
	public Arrival(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
