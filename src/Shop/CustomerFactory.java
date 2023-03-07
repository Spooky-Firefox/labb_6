package Shop;

public class CustomerFactory {
	private int customers = -1;

	public int create() {
		this.customers++;
		return this.customers;
	}

	public int total() {
		return this.customers;
	}
}
