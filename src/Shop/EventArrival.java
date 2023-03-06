package Shop;

import System.EventQueue;
import System.State;

public class EventArrival extends ShopEvent {
	public EventArrival(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventArrival(double startTime, EventQueue eventQueue, int customer) {
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
