package Butik;

import Simulator.EventQueue;
import Simulator.State;

public class Plocka extends ButikEvent {
	public Plocka(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
