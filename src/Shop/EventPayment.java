package Shop;

import System.EventQueue;
import System.State;

public class EventPayment extends ShopEvent {
	public EventPayment(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
