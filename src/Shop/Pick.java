package Shop;

import Simulator.EventQueue;
import Simulator.State;

public class Pick extends ShopEvent {
	public Pick(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(ShopState state) {
	}
}
