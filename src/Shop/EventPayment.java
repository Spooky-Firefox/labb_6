package Shop;

import Controller.EventQueue;
import Controller.State;

/**
 * Represents a customer paying for picked items.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
class EventPayment extends ShopEvent {
	EventPayment(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	/**
	 * Returns The name of the event.
	 * @return the event name.
	 */
	public String toString() {
		return "Betalning";
	}

	/**
	 * Overrides the inherited exec method from Event.
	 * @param ShopState the current shop state
	 */
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
