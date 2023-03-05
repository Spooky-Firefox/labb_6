package Shop;

import System.EventQueue;
import System.State;

public class EventPayment extends ShopEvent {
	public EventPayment(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventPayment(int startTime, EventQueue eventQueue, int customer) {
		this(startTime, eventQueue);
		this.setCustomer(customer);
	}

	public String toString() {
		return "Betalning";
	}

	@Override
	public void execute(ShopState state) {
	}
}
