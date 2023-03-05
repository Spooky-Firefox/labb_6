package Shop;

import System.EventQueue;
import System.State;

public class Arrival extends ShopEvent {
	public Arrival(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
