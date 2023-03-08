package Shop;

import Controller.EventQueue;
import Controller.State;
import Shop.EventArrival;

/**
 * EventStart is the event that will be run at the start of simulation.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class EventStart extends ShopEvent {
	/**
	 * Constructor.
	 * @param time the time when the event should be run
	 * @param eventQueue instance of EventQueue
	 */
	public EventStart(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	/**
	 * Returns The name of the event.
	 * @return the event name.
	 */
	public String toString() {
		return "Start";
	}

	/**
	 * Overrides the inherited exec method from Event.
	 * @param state instance of ShopState
	 */
	@Override
	public void execute(ShopState state) {
		int customer = state.customers.create();
		EventArrival arrival = new EventArrival(
			this.getStartTime() + state.newArrivalTime(), super.getQueue(), customer
		);
		super.getQueue().addEvent(arrival);
	}
}
