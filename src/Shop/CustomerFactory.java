package Shop;

class CustomerFactory {
	private int customers = -1;

	int create() {
		this.customers++;
		return this.customers;
	}

	int total() {
		return this.customers;
	}
}
