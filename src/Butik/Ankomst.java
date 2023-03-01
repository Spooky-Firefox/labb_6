package Butik;

import Simulator.EventQueue;
import Simulator.State;

public class Ankomst extends ButikEvent {
	public Ankomst(int time, EventQueue eventQueue) {
	    super(time, eventQueue);
    }

    @Override
    public void execute(State state) {
    }
}
