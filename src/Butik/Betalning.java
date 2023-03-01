package Butik;

import Simulator.EventQueue;
import Simulator.State;

public class Betalning extends ButikEvent {
	public Betalning(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
