package Shop;

import System.EventQueue;
import System.StopSim;
import System.State;

public class ShopStop extends StopSim {
	public ShopStop(double time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
		state.notify(this);
		super.execute(state);
	}

	@Override
	public String toString() {
		return "Stop";
	}
}
