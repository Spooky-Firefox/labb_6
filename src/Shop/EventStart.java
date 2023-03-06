package Shop;

import System.EventQueue;
import System.State;
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
		int custumerNumber = state.customers.newCustomer();
		EventArrival arrival = new EventArrival(this.getStartTime() + state.newArrivalTime(), super.getQueue(), custumerNumber);
		super.getQueue().addEvent(arrival);
	}
}
