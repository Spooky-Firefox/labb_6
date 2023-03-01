package Main;

import Simulator.EventQueue;
import Butik.ButikState;
import Butik.ButikView;
import Butik.Stängning;
import Simulator.Simulator;
import Simulator.StartSim;
import Simulator.StopSim;

public class RunSim {
	
	public static void main(String[] args){
	
		ButikState butikState = new ButikState();
		butikState.öppen = true;
		
		EventQueue eventQueue = new EventQueue();
		StartSim startSim = new StartSim();
		StopSim stopSim = new StopSim();
		Stängning stängning = new Stängning();
		ButikView butikView = new ButikView(butikState);
		
		eventQueue.addEvent(startSim);
		eventQueue.addEvent(stopSim);
		eventQueue.addEvent(stängning);
		
		Simulator sim = new Simulator(butikState, eventQueue);
	
	}
}
