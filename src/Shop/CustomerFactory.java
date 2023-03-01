package Shop;

public class CustomerFactory {
	private int customers = 0;

	public int newCustomer() {
		this.customers++;
		return this.customers;
	}
}
