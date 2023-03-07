package Main;

import Controller.*;
import Shop.EventClosing;
import Shop.EventStart;
import Shop.ShopState;

import java.util.Random;

public class Optimize {
	private static ShopState runOneSim( // method one
								 int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
								 double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {
		// Sets up initial instances
		ShopState shopState = new ShopState(
				openCheckouts, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax,
				paymentTimeMin, paymentTimeMax, rngSeed);
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

	private static int findMinCheckoutFromSeed( // method two
										 int maxCustomers, double arrivalTime, double pickTimeMin,
										 double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {
		// TODO: make binary search


		// if we have a Checkout for each customer, it doesn't help with more
		int maxCheckouts = maxCustomers;
		int minCheckouts = maxCustomers;
		int minMissedCustomers = Integer.MAX_VALUE;
		for (int i = maxCheckouts; i >0; i--) {
			ShopState state = runOneSim(
					i, maxCustomers, arrivalTime, pickTimeMin, pickTimeMax, paymentTimeMin, paymentTimeMax, rngSeed);
//			System.out.println("\n\n");
//			System.out.println("checkouts "+state.openCheckouts);
//			System.out.println("missed "+state.customersMissed);
			if (state.customersMissed <= minMissedCustomers) {
				minMissedCustomers = state.customersMissed;
				minCheckouts = i;
			}
		}
//		System.out.println("minMissed "+minMissedCustomers);
		return minCheckouts;
	}

	private static int findMinCheckout( // method tre
								 int maxCustomers, double arrivalTime, double pickTimeMin,
								 double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long sourceRand) {
		Random rand = new Random(sourceRand);

		int maxCheckouts = 0;
		int stepsSinceChange = 0;
		while (stepsSinceChange <= 100) {
			int minCheckouts = findMinCheckoutFromSeed(
					maxCustomers, arrivalTime, pickTimeMin, pickTimeMax,
					paymentTimeMin, paymentTimeMax, rand.nextLong());
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
		System.out.println(findMinCheckout(
				5,1,0.5,1,
				2,3,1234));
	}
}
