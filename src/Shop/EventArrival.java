package Shop;

import System.EventQueue;
import System.State;

public class EventArrival extends ShopEvent {
	public EventArrival(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
