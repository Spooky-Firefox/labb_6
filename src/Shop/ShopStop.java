package Shop;

import System.EventQueue;

public class ShopStop extends ShopEvent {
	public ShopStop(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	void execute(ShopState state) {
		state.stop();
	}

	@Override
	public String toString() {
		return "Stop";
	}
}
