package Shop;

import System.State;

public class ShopState extends State
{
	public boolean open;

	public ShopState() {
		this.open = true;
	}

	public boolean isOpen() {
		return this.open;
	}

	public void closeShop() {
		this.open = false;
	}

	// TODO
	// public CustomerFactory getCustomers() {
	// }

	// TODO
	// public CheckoutQueue getCheckout() {
	// }

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
