package Shop;

import Controller.EventQueue;
import Controller.State;

public class EventArrival extends ShopEvent {

	public EventArrival(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.setCustomer(customer);
	}

	public String toString() {
		return "Ankomst";
	}

	@Override
	public void execute(ShopState state) {
		if(state.open && state.shoppingCustomers < state.maxCustomers) {

			state.shoppingCustomers += 1;

			EventPick pick = new EventPick(this.getStartTime() +
			state.newPickTime(), super.getQueue());
			super.getQueue().addEvent(pick);
			int custumerNumber = state.customers.newCustomer();
			EventArrival Arrival = new EventArrival(this.getStartTime() +
					state.newArrivalTime(), super.getQueue(), custumerNumber);
					super.getQueue().addEvent(Arrival);
		}
		else if(state.open && state.shoppingCustomers >= state.maxCustomers) {
			state.customersMissed += 1;
		}

	}
}
