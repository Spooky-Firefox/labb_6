package Shop;

/**
 * "Creates" new customers, which is only represented as numbers.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
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
