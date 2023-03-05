package Shop;

import System.EventQueue;
import System.State;

public class EventPick extends ShopEvent {
	public EventPick(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventPick(int startTime, EventQueue eventQueue, int customer) {
		this(startTime, eventQueue);
		this.setCustomer(customer);
	}

	public String toString() {
		return "Plock";
	}

	@Override
	public void execute(ShopState state) {
		if (state.freeCheckout()) {
			// TODO: randomize start time
			EventPayment payment = new EventPayment(
				super.getStartTime() + 1, super.getQueue()
			);
		}
		else {
			// TODO
			// state.queue.addCustomer(this.customerNumber);
		}
	}
}
