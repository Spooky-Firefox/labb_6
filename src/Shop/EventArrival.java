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
		// if not open, don't let customer in and don't count it as missed
		if (state.open == false) {
			return;
		}

		// always add new arrival event when shop is open
		int customer = state.customers.create();
		EventArrival Arrival = new EventArrival(this.getStartTime() +
			state.newArrivalTime(), super.getQueue(), customer
		);
		super.getQueue().addEvent(Arrival);

		// if shop is open but full, add missed customer and do nothing else
		if (state.customersShopping >= state.maxCustomers) {
			state.customersMissed++;
			return;
		}

		// if shop is open and has space, add shopping customer and pick event
		state.customersShopping++;
		EventPick pick = new EventPick(
			this.getStartTime() + state.newPickTime(), super.getQueue(), this.customer
		);
		super.getQueue().addEvent(pick);
	}
}
