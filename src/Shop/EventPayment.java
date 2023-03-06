package Shop;

import System.EventQueue;
import System.State;

public class EventPayment extends ShopEvent {
	public EventPayment(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public EventPayment(double startTime, EventQueue eventQueue, int customer) {
		this(startTime, eventQueue);
		this.setCustomer(customer);
	}

	public String toString() {
		return "Betalning";
	}

	@Override
	public void execute(ShopState state) {
		state.shoppingCustomers--;
		state.customersPayed++;
		if(state.checkoutQueue.hasNext()) {
			state.checkoutQueue.nextCustomer();
			EventPayment payment = new EventPayment(
					super.getStartTime() + state.newPaymentTime(), super.getQueue());
			super.getQueue().addEvent(payment);
			state.checkoutQueue.useCheckout();
		}
		else {
			state.checkoutQueue.makeFreeCheckout();
		}
		
	}
}
