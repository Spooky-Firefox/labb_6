package Main;

import Shop.*;
import System.*;

public class RunSim {
	public static void main(String[] args){
		ShopState shopState = new ShopState();
		ShopView shopView = new ShopView(shopState);
		EventQueue eventQueue = new EventQueue(shopState);

		// Adds initial events
		EventStart eventStart = new EventStart(0, eventQueue);
		eventQueue.addEvent(eventStart);
		StopSim stopSim = new StopSim(999, eventQueue);
		eventQueue.addEvent(stopSim);
		EventClosing eventClose = new EventClosing(10, eventQueue);
		eventQueue.addEvent(eventClose);

		// Sets up and runs the simulator
		Simulator sim = new Simulator(shopState, eventQueue);
		System.out.println("Running simulation...");
		sim.runLoop();
		System.out.println("End of simulation");
	}
}
