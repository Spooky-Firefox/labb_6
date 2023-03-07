package Shop;

import java.util.ArrayList;

public class CheckoutQueue {
	// This list represents the current payment queue
	private ArrayList<Integer> customerQueue;
	// While this list tracks which customers HAS BEEN queueing (at least once)
	private ArrayList<Integer> customerQueuedOnce;
	private int maxCheckouts;
	private int freeCheckouts;

	public CheckoutQueue(int maxCheckouts) {
		// TODO: add max checkouts from state, so can measure free checkouts
		this.freeCheckouts = maxCheckouts;
		this.maxCheckouts = maxCheckouts;
		this.customerQueue = new ArrayList<>();
		this.customerQueuedOnce = new ArrayList<Integer>();
	}

	public void useCheckout() {
		this.freeCheckouts--;
	}

	public void makeFreeCheckout() {
		this.freeCheckouts++;
	}

	public int amountFree() {
		return this.freeCheckouts;
	}

	public boolean hasFree() {
		return (this.amountFree() > 0);
	}

	public void addCustomer(int customer) {
		this.customerQueue.add(customer);
		// Tracks which customers had to stand in line
		if (this.customerQueuedOnce.contains(customer) == false) {
			this.customerQueuedOnce.add(customer);
		}
	}

	public int nextCustomer() {
		return this.customerQueue.remove(0);

	}

	public boolean hasNext() {
		return !this.customerQueue.isEmpty();
	}

	public int queuedCurrent() {
		return this.customerQueue.size();
	}

	public int queuedOnce() {
		return this.customerQueuedOnce.size();
	}

	@Override
	public String toString() {
		return this.customerQueue.toString();
	}
}
