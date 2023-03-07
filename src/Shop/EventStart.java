package Shop;

import Controller.EventQueue;
import Controller.State;
import Shop.EventArrival;

public class EventStart extends ShopEvent {
	public EventStart(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String toString() {
		return "Start";
	}

	@Override
	public void execute(ShopState state) {
		int customer = state.customers.newCustomer();
		EventArrival arrival = new EventArrival(
			this.getStartTime() + state.newArrivalTime(), super.getQueue(), customer
		);
		super.getQueue().addEvent(arrival);
	}
}
