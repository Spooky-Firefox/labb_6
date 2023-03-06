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
		state.shoppingCustomers--;
		state.customersPayed++;
		// customer is done, free checkout
		state.checkoutQueue.makeFreeCheckout();

		// if there are more customer occupy checkout with new customer
		if(state.checkoutQueue.hasNext()) {
			state.checkoutQueue.nextCustomer();
			EventPayment payment = new EventPayment(
					super.getStartTime() + state.newPaymentTime(), super.getQueue(),this.customer);
			super.getQueue().addEvent(payment);
			state.checkoutQueue.useCheckout();
		}
		else {
			state.checkoutQueue.makeFreeCheckout();
		}
	}
}
