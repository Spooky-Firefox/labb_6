package Shop;

import Simulator.EventQueue;
import Simulator.State;

public class Closing extends ShopEvent {
	public Closing(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
