package Main;

import Simulator.EventQueue;
import Butik.ButikState;
import Simulator.Simulator;

public class RunSim {
	
	public static void main(String[] args){
	
		ButikState butikState = new ButikState();
		butikState.öppen = true;
		
		EventQueue eventQueue = new EventQueue();
		
		Simulator sim = new Simulator(butikState, eventQueue);
	
	}
}
