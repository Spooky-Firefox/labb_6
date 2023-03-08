package Shop;

import Controller.EventQueue;
import Controller.State;

/**
 * Represents an event where a customer is picking items inside the shop.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
class EventPick extends ShopEvent {
	EventPick(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	/**
	 * Returns The name of the event.
	 * @return the event name.
	 */
	public String toString() {
		return "Plock";
	}

	/**
	 * Overrides the inherited exec method from Event.
	 * @param ShopState the current shop state
	 */
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
