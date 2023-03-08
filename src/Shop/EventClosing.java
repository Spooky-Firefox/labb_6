package Shop;

import Controller.EventQueue;

/**
 * EventClosing is an event that causes the shop to close for the day.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class EventClosing extends ShopEvent {
	/**
	 * Constructor.
	 * @param time the time when the event should be run
	 * @param eventQueue instance of EventQueue
	 */
	public EventClosing(double time, EventQueue eventQueue) {
		super(time, eventQueue);
		this.customer = -1;
	}

	/**
	 * Returns The name of the event.
	 * @return the event name.
	 */
	public String toString() {
		return "Stanger";
	}

	/**
	 * Overrides the inherited exec method from Event.
	 * @param state instance of ShopState
	 */
	@Override
	public void execute(ShopState state) {
		state.open = false;
	}
}
