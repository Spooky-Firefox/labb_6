package Butik;

import Simulator.EventQueue;
import Simulator.State;

public class Stängning extends ButikEvent {
	public Stängning(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
