package Shop;

import Controller.State;
import Tools.UniformRandomStream;
import Tools.ExponentialRandomStream;

/**
 * ShopState extends the public State class and contains parameters required to simulate
 * a shop.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class ShopState extends State {
	// NOTICE:
	// All variables has pkg visibility because the amount of getters would be crazy...!
	//
	// Shop parameters, from pg. 5 (comment number equals parameter on that page),
	// locked to single declaration using the "final" keyword.
	final int openCheckouts; // 1
	final int maxCustomers; // 2
	final double arrivalTime; // 3
	final double paymentTimeMin, paymentTimeMax; // 4
	final double pickTimeMin, pickTimeMax; // 5
	// TODO: seems unneccesary since opening time is set using the stop event???
	// final double openTime; // 6
	final long rngSeed; // 7

	// Shop statistics, from the end of pg. 5
	int customersShopping = 0;
	int customersWaited = 0;
	int customersPayed = 0;
	int customersMissed = 0;
	double timeEmptyCheckouts = 0;
	double timeWaitingCustomers = 0;
	double lastPay = 0;

	// Extra, custom runtime instances
	boolean open = true;
	CustomerFactory customers = new CustomerFactory();
	CheckoutQueue checkoutQueue;
	private double deltaTime; // used for some statistics calculations
	private ExponentialRandomStream arrivalRNG;
	private UniformRandomStream pickRNG;
	private UniformRandomStream paymentRNG;

	/**
	 * Constructor.
	 * @param openCheckouts amount of open checkouts
	 * @param maxCustomers max amount of customers inside the shop
	 * @param arrivalTime lambda time for determining when new customers arrives
	 * @param pickTimeMin time range for letting customers "pick up items in shop"
	 * @param pickTimeMax time range for letting customers "pick up items in shop"
	 * @param paymentTimeMin time range until customers can pay for items
	 * @param paymentTimeMax time range until customers can pay for items
	 * @param rngSeed value used to seed the random number generators
	 */
	public ShopState(
			int openCheckouts, int maxCustomers, double arrivalTime, double pickTimeMin,
			double pickTimeMax, double paymentTimeMin, double paymentTimeMax, long rngSeed
	) {
		this.openCheckouts = openCheckouts;
		this.maxCustomers = maxCustomers;
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

	/**
	 * setTime overrides the same method inherited from State, since we want to track
	 * an internal delta time while running.
	 * @param newTime the new time to set
	 */
	@Override
	public void setTime(double newTime) {
		this.deltaTime = newTime - this.currentTime;
		super.setTime(newTime);
	}

	/**
	 * getMissedCustomers returns the amount of customers not allowed inside the shop
	 * if it was full at the moment.
	 * @return amount of missed customers
	 */
	public int getMissedCustomers() {
		return this.customersMissed;
	}

	String prettyOpen() {
		if (this.open){
			return "O";
		} else {
			return "S";
		}
	}

	double newArrivalTime() {
		return this.arrivalRNG.next();
	}

	double newPickTime() {
		return this.pickRNG.next();
	}

	double newPaymentTime() {
		return this.paymentRNG.next();
	}

	void updateStatistics(){
		if(this.open || this.customersShopping > 0) {
			// sum of total time in checkout queue
			this.timeWaitingCustomers = this.timeWaitingCustomers +
				this.checkoutQueue.queuedCurrent() * this.deltaTime;
			// sum of time of empty checkouts
			this.timeEmptyCheckouts = this.timeEmptyCheckouts +
				this.checkoutQueue.amountFree() * this.deltaTime;
		}
	}

}
