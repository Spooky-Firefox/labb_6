package Butik;

import Simulator.Event;
import Simulator.EventQueue;
import Simulator.State;

public abstract class ButikEvent extends Event {
	public int kundNummer;

	public ButikEvent(int time, EventQueue eventQueue) {
	    super(time, eventQueue);
    }
}
