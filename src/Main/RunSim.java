package Main;

import Shop.*;
import Controller.*;

/**
 * Class to run a simulation of a shop.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class RunSim {

	/**
	 * Main method run when executing program.
	 * It creates a ShopState and ShopView which represents a shop and prints shop stats.
	 * EventQueue and Simulator is also created to run the simulated shop.
	 * @param args a String array of program arguments
	 */
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
		Event eventStart = new EventStart(0, eventQueue);
		eventQueue.addEvent(eventStart);
		Event stopSim = new StopSim(999, eventQueue);
		eventQueue.addEvent(stopSim);
		Event eventClose = new EventClosing(10, eventQueue);
		eventQueue.addEvent(eventClose);

		// Sets up and runs the simulator
		Simulator sim = new Simulator(shopState, eventQueue);
		sim.runLoop();
	}
}
