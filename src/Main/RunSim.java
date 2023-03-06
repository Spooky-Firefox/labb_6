package Main;

import Shop.*;
import System.*;

public class RunSim {
	public static void main(String[] args){
		// Parameters from first example
		int openCheckouts = 2;
		int maxCustomers = 5;
		double arrivalTime = 1.0;
		double pickTimeMin = 0.5;
		double pickTimeMax = 1.0;
		double paymentTimeMin = 2.0;
		double paymentTimeMax = 3.0;
		long rngSeed = 1234;

		// Sets up initial instances
		ShopState shopState = new ShopState(
			openCheckouts, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax,
			paymentTimeMin, paymentTimeMax, rngSeed
		);
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
		sim.runLoop();
	}
}
