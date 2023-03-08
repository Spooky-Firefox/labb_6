package Shop;

import Controller.EventQueue;
import Controller.State;

class EventPick extends ShopEvent {
	EventPick(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	public String toString() {
		return "Plock";
	}

	@Override
	public void execute(ShopState state) {
		// If no free counters, add customer to queue
		// and increase customersWaited with one
		if (state.checkoutQueue.hasFree() == false) {
			state.checkoutQueue.addCustomer(this.customer);
			state.customersWaited++;
			return;
		}

		// else, decrease free counters -1 and add payment event
		state.checkoutQueue.useCheckout();
		EventPayment payment = new EventPayment(
			this.getStartTime() + state.newPaymentTime(), super.getQueue(), this.customer
		);
		super.getQueue().addEvent(payment);
	}
}
