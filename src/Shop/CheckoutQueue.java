package Shop;

import java.util.ArrayList;

public class CheckoutQueue {
	private ArrayList<Integer> customers;

	public CheckoutQueue() {
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

	@Override
	public String toString() {
		return this.customers.toString();
	}
}
