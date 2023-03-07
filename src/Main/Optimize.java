package Main;

import Controller.Event;
import Controller.EventQueue;
import Controller.Simulator;
import Controller.StopSim;
import Shop.EventClosing;
import Shop.EventStart;
import Shop.ShopState;

public class Optimize {
	private ShopState runOneSim( // method one
			int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
			double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {
		// Sets up initial instances
		ShopState shopState = new ShopState(
				openCheckouts, maxCustomers,arrivalTime,pickTimeMin,pickTimeMax,
				paymentTimeMin,paymentTimeMax,rngSeed);
		EventQueue eventQueue = new EventQueue(shopState);

		// Adds initial events
		Event eventStart = new EventStart(0, eventQueue);
		eventQueue.addEvent(eventStart);
		Event stopSim = new StopSim(999, eventQueue);
		eventQueue.addEvent(stopSim);
		Event eventClose = new EventClosing(10, eventQueue);
		eventQueue.addEvent(eventClose);

		// Sets up and runs the simulator
		Simulator sim = new Simulator(shopState, eventQueue);
		sim.runLoop();

		return shopState;
	}

	private int testSeed( // method two
		  int maxCustomers, double arrivalTime, double pickTimeMin,
		  double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {
		// TODO: make binary search


		// if we have a Checkout for each customer, it doesn't help with more
		int maxCheakouts = maxCustomers;
		int minCheakouts = maxCustomers;
		int missedCustomers = Integer.MAX_VALUE;
		for (int i = 1; i <= maxCheakouts ; i++) {
			ShopState state = runOneSim(
				i, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax, paymentTimeMin, paymentTimeMax, rngSeed);
			if (state.customersMissed < missedCustomers){
				minCheakouts = i;
			}
		}

		return minCheakouts;
	}

	public static void main(String[] args) {
	}
}
