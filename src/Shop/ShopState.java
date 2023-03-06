package Shop;

import System.State;
import Tools.UniformRandomStream;
import Tools.ExponentialRandomStream;

public class ShopState extends State {
	// used for some statistics calculations
	private int deltaTime;

	// Shop parameters, from pg. 5 (comment number equals parameter on that page):
	// - using public keyword so that
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
	int freeCheakouts // used to se if to enter queue or payment
	int haveQued; // se page 9, point j
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
		this.freeCheakouts = openCheckouts; // all cheakouts are free att start
		this.haveQued = 0;

		this.maxCustomers = maxCustomers;
		this.shoppingCustomers = 0;

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
	public void updateStatistics(){
		// TODO implement updating of statistics and notify observers of such change
		// sum of time of empty checkouts
		// sum of total time in checkout queue
		// for the sum of checkout queue time and total time of empty checkouts
		// delta time is required
		// a example of calculating the sum queue time
		// queueTime = queueTime + checkoutQueue.size()*deltaTime
	}

	@Override
	public void setTime(int newTime) {
		this.deltaTime = newTime - this.currentTime;
		super.setTime(newTime);
	}
}
