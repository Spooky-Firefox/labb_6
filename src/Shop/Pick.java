package Shop;

import Simulator.EventQueue;
import Simulator.State;

public class Pick extends ShopEvent {
	private int customerNumber;
	public Pick(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}
	public Pick(int startTime, int customerNumber, EventQueue eventQueue) {
		super(startTime, eventQueue);
		this.customerNumber = customerNumber;
	}

	@Override
	public void execute(ShopState state) {
		if (state.freeCheckout()) {
			Payment payment = new Payment(super.getStartTime() + 1, super.getQueue());
		}
		else {
			state.queue.addCustomer(this.customerNumber);
		}
	}
}
