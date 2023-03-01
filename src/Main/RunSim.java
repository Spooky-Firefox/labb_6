package Main;

import Simulator.*;
import Butik.*;

public class RunSim {
	public static void main(String[] args){
		ButikState butikState = new ButikState();
		ButikView butikView = new ButikView(butikState);
		butikState.öppen = true;

		EventQueue eventQueue = new EventQueue();
		StartSim startSim = new StartSim(0, eventQueue);
		StopSim stopSim = new StopSim(999, eventQueue);
		Stängning stängning = new Stängning(10, eventQueue);

		Simulator sim = new Simulator(butikState, eventQueue);
	}
}
