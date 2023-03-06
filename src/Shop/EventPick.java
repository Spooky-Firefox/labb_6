package Shop;

import Controller.EventQueue;
import Controller.State;

public class EventPick extends ShopEvent {
	public EventPick(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	public String toString() {
		return "Plock";
	}

	@Override
	public void execute(ShopState state) {
		if (state.checkoutQueue.hasFree()) {
			EventPayment payment = new EventPayment(
					super.getStartTime() + state.newPaymentTime(), super.getQueue(),this.customer);
			super.getQueue().addEvent(payment);
			state.checkoutQueue.useCheckout();
		}
		else {
			state.checkoutQueue.addCustomer(this.customer);
		}
	}
}
