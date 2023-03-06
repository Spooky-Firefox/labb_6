package Shop;

import java.util.ArrayList;

public class CheckoutQueue {
	private ArrayList<Integer> customers;
	private int maxCheckouts;
	private int freeCheckouts;

	public CheckoutQueue(int maxCheckouts) {
		// TODO: add max checkouts from state, so can measure free checkouts
		this.freeCheckouts = maxCheckouts;
		this.maxCheckouts = maxCheckouts;
		this.customers = new ArrayList<>();
	}
	public void makeFreeCheckout() {
		this.freeCheckouts++;
	}
	public void useCheckout() {
		this.freeCheckouts--;
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
		return this.freeCheckouts;
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
