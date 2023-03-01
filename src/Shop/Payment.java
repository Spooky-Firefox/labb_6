package Shop;

import Simulator.EventQueue;
import Simulator.State;

public class Payment extends ShopEvent {
	public Payment(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
