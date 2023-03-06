package Shop;

public class CustomerFactory {
	private int customers = -1;

	public int newCustomer() {
		this.customers++;
		return this.customers;
	}
}
