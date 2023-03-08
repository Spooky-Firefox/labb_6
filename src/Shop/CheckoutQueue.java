package Shop;

import java.util.ArrayList;

/**
 * Tracks the payment queue at the shop's checkout.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
class CheckoutQueue {
	// This list represents the current payment queue
	private ArrayList<Integer> customerQueue;
	// While this list tracks which customers HAS BEEN queueing (at least once)
	private ArrayList<Integer> customerQueuedOnce;
	private int maxCheckouts;
	private int freeCheckouts;

	CheckoutQueue(int maxCheckouts) {
		this.freeCheckouts = maxCheckouts;
		this.maxCheckouts = maxCheckouts;
		this.customerQueue = new ArrayList<>();
		this.customerQueuedOnce = new ArrayList<Integer>();
	}

	void useCheckout() {
		this.freeCheckouts--;
	}

	void makeFreeCheckout() {
		this.freeCheckouts++;
	}

	int amountFree() {
		return this.freeCheckouts;
	}

	boolean hasFree() {
		return (this.amountFree() > 0);
	}

	void addCustomer(int customer) {
		this.customerQueue.add(customer);
		// Tracks which customers had to stand in line
		if (this.customerQueuedOnce.contains(customer) == false) {
			this.customerQueuedOnce.add(customer);
		}
	}

	int nextCustomer() {
		return this.customerQueue.remove(0);

	}

	boolean hasNext() {
		return !this.customerQueue.isEmpty();
	}

	int queuedCurrent() {
		return this.customerQueue.size();
	}

	int queuedOnce() {
		return this.customerQueuedOnce.size();
	}

	/**
	 * Returns a string representation of the checkout queue.
	 * @return the checkout queue.
	 */
	@Override
	public String toString() {
		return this.customerQueue.toString();
	}
}
