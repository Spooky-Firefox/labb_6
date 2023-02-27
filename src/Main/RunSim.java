package Main;

import Simulator.EventQueue;
import Butik.ButikState;
import Butik.ButikView;
import Butik.St�ngning;
import Simulator.Simulator;
import Simulator.StartSim;
import Simulator.StopSim;

public class RunSim {
	
	public static void main(String[] args){
	
		ButikState butikState = new ButikState();
		butikState.�ppen = true;
		
		EventQueue eventQueue = new EventQueue();
		StartSim startSim = new StartSim();
		StopSim stopSim = new StopSim();
		St�ngning st�ngning = new St�ngning();
		ButikView butikView = new ButikView(butikState);
		
		eventQueue.addEvent(startSim);
		eventQueue.addEvent(stopSim);
		eventQueue.addEvent(st�ngning);
		
		Simulator sim = new Simulator(butikState, eventQueue);
	
	}
}
