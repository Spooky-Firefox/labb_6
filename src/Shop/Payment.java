package Shop;

import System.EventQueue;
import System.State;

public class Payment extends ShopEvent {
	public Payment(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
