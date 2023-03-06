package Shop;

import System.State;
import Tools.UniformRandomStream;
import Tools.ExponentialRandomStream;

public class ShopState extends State {
	// used for some statistics calculations
	private double deltaTime;

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
	int freeCheckouts; // used to se if to enter queue or payment
	boolean open = true;
	CustomerFactory customers = new CustomerFactory();
	CheckoutQueue checkoutQueue;
	ExponentialRandomStream arrivalRNG;
	UniformRandomStream pickRNG;
	UniformRandomStream paymentRNG;

	public ShopState(
			int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
			double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed) {

		this.openCheckouts = openCheckouts;
		this.freeCheckouts = openCheckouts; // all checkouts are free att start
		this.timeEmptyCheckouts = 0;
		this.timeWaitingCustomers = 0;

		this.maxCustomers = maxCustomers;
		this.shoppingCustomers = 0;
		this.customersWaited = 0;
		this.customersPayed = 0;
		this.customersMissed = 0;

		this.arrivalTime = arrivalTime;
		this.pickTimeMin = pickTimeMin;
		this.pickTimeMax = pickTimeMax;
		this.paymentTimeMin = paymentTimeMin;
		this.paymentTimeMax = paymentTimeMax;
		this.rngSeed = rngSeed;
		this.checkoutQueue = new CheckoutQueue(openCheckouts);
		this.arrivalRNG = new ExponentialRandomStream(arrivalTime, rngSeed);
		this.pickRNG= new UniformRandomStream(pickTimeMin, pickTimeMax, rngSeed);
		this.paymentRNG = new UniformRandomStream(paymentTimeMin, paymentTimeMax, rngSeed);

	}
	public void updateStatistics(){
		// sum of total time in checkout queue
		this.timeWaitingCustomers = this.timeWaitingCustomers + this.checkoutQueue.size() * this.deltaTime;
		// sum of time of empty checkouts
		this.timeEmptyCheckouts = this.timeEmptyCheckouts + this.freeCheckouts * this.deltaTime;
	}

	@Override
	public void setTime(double newTime) {
		this.deltaTime = newTime - this.currentTime;
		super.setTime(newTime);
	}

	public String prettyOpen() {
		if (this.open){
			return "O";
		} else {
			return "S";
		}
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
}
