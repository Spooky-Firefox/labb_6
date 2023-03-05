package Shop;

import System.EventQueue;

public class EventClosing extends ShopEvent {
	public EventClosing(double time, EventQueue eventQueue) {
		super(time, eventQueue);
		this.setCustomer(-1);
	}

	public String toString() {
		return "Stanger";
	}

	@Override
	public void execute(ShopState state) {
		state.closeShop();
	}
}
