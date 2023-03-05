package Shop;

import System.EventQueue;
import System.State;

public class EventArrival extends ShopEvent {
	public EventArrival(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventArrival(int startTime, EventQueue eventQueue, int customer) {
		this(startTime, eventQueue);
		this.setCustomer(customer);
	}

	public String toString() {
		return "Ankomst";
	}

	@Override
	public void execute(ShopState state) {
	}
}
