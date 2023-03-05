package Shop;

import System.EventQueue;

public class EventClosing extends ShopEvent {
	public EventClosing(int time, EventQueue eventQueue) {
		super(time, eventQueue);
		this.setCustomer(0);
	}

	public String toString() {
		return "Stanger";
	}

	@Override
	public void execute(ShopState state) {
		state.closeShop();
	}
}
