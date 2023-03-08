package Shop;

import Controller.EventQueue;
import Controller.State;

/**
 * Represents a customer arriving to the shop.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
class EventArrival extends ShopEvent {

	EventArrival(double startTime, EventQueue eventQueue, int customer) {
		super(startTime, eventQueue);
		this.customer = customer;
	}

	/**
	 * Returns The name of the event.
	 * @return the event name.
	 */
	public String toString() {
		return "Ankomst";
	}

	/**
	 * Overrides the inherited exec method from Event.
	 * @param ShopState the current shop state
	 */
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
