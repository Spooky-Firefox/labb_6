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
		EventArrival arrival = new EventArrival(state.newArrivalTime(), super.getQueue());
		super.getQueue().addEvent(arrival);
	}
}
