package Main;

import Controller.*;
import Shop.ShopState;
import Shop.EventStart;
import Shop.EventClosing;

import java.util.Random;

public class Optimize {

	// Method one: run one simulation with fixed params, but don't print output and
	// return end state.
	private static ShopState runOneSim(
			int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
			double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {

		// Sets up initial instances
		ShopState shopState = new ShopState(
			openCheckouts, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax,
			paymentTimeMin, paymentTimeMax, rngSeed
		);
		EventQueue eventQueue = new EventQueue(shopState);

		// Adds initial events
		Event eventStart = new EventStart(0, eventQueue);
		eventQueue.addEvent(eventStart);
		Event stopSim = new StopSim(999, eventQueue);
		eventQueue.addEvent(stopSim);
		Event eventClose = new EventClosing(10, eventQueue);
		eventQueue.addEvent(eventClose);

		// Sets up and runs the simulator silently
		Simulator sim = new Simulator(shopState, eventQueue);
		sim.runLoop();
		return shopState;
	}

	// Method two: Using first method, run multiple, sequential simulations and find the
	// least amount of checkouts that causes the least amount of missed customers.
	// It returns the optimal number of checkouts.
	private static int findMinCheckoutFromSeed(
			int maxCustomers, double arrivalTime, double pickTimeMin,
			double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {

		// if we have a Checkout for each customer, it doesn't help with more
		int maxCheckouts = maxCustomers;
		int minCheckouts = maxCustomers;
		int minMissedCustomers = Integer.MAX_VALUE;
		for (int i = maxCheckouts; i > 0; i--) {
			ShopState state = runOneSim(
				i, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax, paymentTimeMin,
				paymentTimeMax, rngSeed
			);
			if (state.getMissedCustomers() <= minMissedCustomers) {
				minMissedCustomers = state.getMissedCustomers();
				minCheckouts = i;
			}
		}
		return minCheckouts;
	}

	// Method three: Using the second method, run even more simulations using randomized
	// seed values to find an optimal amount of free checkouts that works the best (over
	// 100 loops). It returns the best amount of checkouts.
	private static int findMinCheckout(
			int maxCustomers, double arrivalTime, double pickTimeMin, double pickTimeMax,
			double paymentTimeMin, double paymentTimeMax, long sourceRand) {

		Random rand = new Random(sourceRand);
		int maxCheckouts = 0;
		int stepsSinceChange = 0;
		while (stepsSinceChange <= 100) {
			int minCheckouts = findMinCheckoutFromSeed(
				maxCustomers, arrivalTime, pickTimeMin, pickTimeMax, paymentTimeMin,
				paymentTimeMax, rand.nextLong()
			);
			if (minCheckouts > maxCheckouts){
				maxCheckouts = minCheckouts;
				stepsSinceChange = 0;
			} else {
				stepsSinceChange++;
			}
		}
		return maxCheckouts;
	}

	public static void main(String[] args) {
		System.out.println(findMinCheckout(5,1,0.5,1,2,3,1234));
	}
}
