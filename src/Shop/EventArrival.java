package Shop;

import Controller.EventQueue;
import Controller.State;

public class EventArrival extends ShopEvent {

	public EventArrival(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	public String toString() {
		return "Ankomst";
	}

	@Override
	public void execute(ShopState state) {
		// if store is open create new arrival
		if (state.open){
			int custumerNumber = state.customers.newCustomer();
			EventArrival Arrival = new EventArrival(this.getStartTime() +
					state.newArrivalTime(), super.getQueue(), custumerNumber);
			super.getQueue().addEvent(Arrival);

			// if store is not full create a pick event
			if(state.shoppingCustomers < state.maxCustomers) {

				state.shoppingCustomers += 1;

				EventPick pick = new EventPick(this.getStartTime() +
				state.newPickTime(), super.getQueue(),this.customer);
				super.getQueue().addEvent(pick);
			}
			// if the store is full increase missed customers
			else {
				state.customersMissed += 1;
		}
		}

	}
}
