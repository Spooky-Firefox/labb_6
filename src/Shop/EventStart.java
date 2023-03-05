package Shop;

import System.EventQueue;
import System.State;
import Shop.EventArrival;

public class EventStart extends ShopEvent {
	public EventStart(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	public String toString() {
		return "Start";
	}

	@Override
	public void execute(ShopState state) {
		// TODO: randomize start time
		EventArrival arrival = new EventArrival(
			super.getStartTime() + 1, super.getQueue()
		);
		super.getQueue().addEvent(arrival);
	}
}
