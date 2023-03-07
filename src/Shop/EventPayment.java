package Shop;

import Controller.EventQueue;
import Controller.State;

public class EventPayment extends ShopEvent {
	public EventPayment(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	public String toString() {
		return "Betalning";
	}

	@Override
	public void execute(ShopState state) {
		state.customersPayed++;
		state.customersShopping--;
		state.lastPay = this.getStartTime();

		// if checkoutqueue is empty, free up a counter
		if (state.checkoutQueue.hasNext() == false) {
			state.checkoutQueue.makeFreeCheckout();
			return;
		}

		// else, pick next waiting customer and add new payment event
		int customer = state.checkoutQueue.nextCustomer();
		EventPayment payment = new EventPayment(
			this.getStartTime() + state.newPaymentTime(), super.getQueue(), customer
		);
		super.getQueue().addEvent(payment);
	}
}
