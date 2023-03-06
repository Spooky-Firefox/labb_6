package Shop;

import System.State;
import Tools.UniformRandomStream;
import Tools.ExponentialRandomStream;

public class ShopState extends State
{
	// Shop parameters, from pg. 5 (comment number equals parameter on that page):
	// - using packet visibility for ease of access (missing public/private keyword)
	// - but locked to single declaration (using the "final" keyword)
	final int openCheckouts; // 1
	final int maxCustomers; // 2
	final double arrivalTime; // 3
	final double paymentTimeMin, paymentTimeMax; // 4
	final double pickTimeMin, pickTimeMax; // 5
	// TODO: seems unneccesary since opening time is set using the stop event???
	// final double openTime; // 6
	final long rngSeed; // 7

	// Shop statistics, from the end of pg. 5
	int customersWaited;
	int customersPayed;
	int customersMissed;
	double timeEmptyCheckouts;
	double timeWaitingCustomers;

	// Extra, custom runtime instances
	int shoppingCustomers;
	boolean open = true;
	CustomerFactory customers = new CustomerFactory();
	CheckoutQueue checkoutQueue = new CheckoutQueue();
	ExponentialRandomStream arrivalRNG;
	UniformRandomStream pickRNG;
	UniformRandomStream paymentRNG;

	public ShopState(
		int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
		double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {
		this.openCheckouts = openCheckouts;
		this.maxCustomers = maxCustomers;
		this.arrivalTime = arrivalTime;
		this.pickTimeMin = pickTimeMin;
		this.pickTimeMax = pickTimeMax;
		this.paymentTimeMin = paymentTimeMin;
		this.paymentTimeMax = paymentTimeMax;
		this.rngSeed = rngSeed;
		this.arrivalRNG = new ExponentialRandomStream(arrivalTime, rngSeed);
		this.pickRNG= new UniformRandomStream(pickTimeMin, pickTimeMax, rngSeed);
		this.paymentRNG = new UniformRandomStream(paymentTimeMin, paymentTimeMax, rngSeed);
	}

	public double newArrivalTime() {
		return this.arrivalRNG.next();
	}

	public double newPickTime() {
		return this.pickRNG.next();
	}

	public double newPaymentTime() {
		return this.paymentRNG.next();
	}

	public String prettyOpen() {
		if (this.open) {
			return "O";
		}
		return "S";
	}

	public void updateStatistics(){
		// TODO implement updating of statistics
		// sum of time of empty checkouts
		// sum of total time in checkout queue
		// for the sum of checkout queue time and total time of empty checkouts
		// delta time is required
		// a example of calculating the sum queue time
		// queueTime = queueTime + checkoutQueue.size()*deltaTime
	}
}
