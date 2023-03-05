package Shop;

import System.EventQueue;
import System.State;

public class EventPick extends ShopEvent {
	private int customerNumber;

	public EventPick(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventPick(int startTime, int customerNumber, EventQueue eventQueue) {
		super(startTime, eventQueue);
		this.customerNumber = customerNumber;
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
