package Shop;

import System.State;

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
	private int customersWaited;
	private int customersPayed;
	private int customersMissed;
	private double timeEmptyCheckouts;
	private double timeWaitingCustomers;

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

	public String prettyOpen() {
		if (isOpen()) {
			return "O";
		}
		return "S";
	}

	// public CustomerFactory getCustomers() {
		// return this.customers;
	// }

	// public CheckoutQueue getCheckout() {
		// return this.checkoutQueue;
	// }

	public int freeCheckouts() {
		// TODO: amount of free checkouts
		return -1;
	}

	public boolean hasFreeCheckout() {
		return (freeCheckouts() > 0);
	}

	public int getCheckoutLength() {
		return this.checkoutQueue.size();
	}

	public String prettyCheckout() {
		return this.checkoutQueue.toString();
	}

	public int getShoppingCustomers() {
		// TODO
		return -1;
	}

	public int getCustomersWaited() {
		return this.customersWaited;
	}

	public int getCustomersPayed() {
		return this.customersPayed;
	}

	public int getCustomersMissed() {
		return this.customersMissed;
	}

	public double getTimeEmptyCheckouts() {
		return this.timeEmptyCheckouts;
	}

	public double getTimeWaitingCustomers() {
		return this.timeWaitingCustomers;
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
