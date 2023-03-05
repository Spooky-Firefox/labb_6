package Shop;

import System.State;

public class ShopState extends State
{
	// Shop parameters, from pg. 5 (comment number equals parameter on that page)
	// using packet visibility for ease of access.
	int openCheckouts; // 1
	int maxCustomers; // 2
	double arrivalTime; // 3
	double paymentTimeMin, paymentTimeMax; // 4
	double pickTimeMin, pickTimeMax; // 5
	// TODO: seems unneccesary since opening time is set using the stop event???
	// private double openTime; // 6
	long rngSeed; // 7

	// Shop statistics, from the end of pg. 5
	int customersPayed;
	int customersMissed;
	double timeEmptyCheckouts;
	double timeWaitingCustomers;

	// Runtime instances
	private boolean open = true;
	private CustomerFactory customers = new CustomerFactory();
	private CheckoutQueue checkoutQueue = new CheckoutQueue();

	public ShopState(
		int openCheckouts, int maxCustomers, double arrivalTime, double paymentTimeMin,
		double paymentTimeMax, double pickTimeMin, double pickTimeMax, long rngSeed) {
		this.openCheckouts = openCheckouts;
		this.maxCustomers = maxCustomers;
		this.arrivalTime = arrivalTime;
		this.paymentTimeMin = paymentTimeMin;
		this.paymentTimeMax = paymentTimeMax;
		this.pickTimeMin = pickTimeMin;
		this.pickTimeMax = pickTimeMax;
		this.rngSeed = rngSeed;
	}

	public boolean isOpen() {
		return this.open;
	}

	public void closeShop() {
		this.open = false;
	}

	public CustomerFactory getCustomers() {
		return this.customers;
	}

	public CheckoutQueue getCheckout() {
		return this.checkoutQueue;
	}

	public boolean freeCheckout() {
		// TODO: check for a free checkout
		return false;
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

}
