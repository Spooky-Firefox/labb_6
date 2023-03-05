package Shop;

import System.EventQueue;

public class Closing extends ShopEvent {
	public Closing(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
		state.open = false;
	}
}
