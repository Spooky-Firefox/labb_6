package Shop;

import java.util.ArrayList;

public class CheckoutQueue {
	private ArrayList<Integer> customers;

	public CheckoutQueue() {
		// TODO: add max checkouts from state, so can measure free checkouts
		customers = new ArrayList<>();
	}

	public void addCustomer(int customersNumber) {
		this.customers.add(customersNumber);
	}

	public int nextCustomer() {
		return this.customers.remove(0);
	}

	public boolean hasNext() {
		return !this.customers.isEmpty();
	}

	public int size() {
		return customers.size();
	}

	public int noFree() {
		// TODO: number of free checkouts
		return -1;
	}

	public boolean hasFree() {
		return (this.noFree() > 0);
	}

	// public String prettyCheckout() {
		// return this.checkoutQueue.toString();
	// }

	@Override
	public String toString() {
		return this.customers.toString();
	}
}
