package Shop;

import java.util.ArrayList;

public class KassaQueue {
    private ArrayList<Integer> customers;

    public KassaQueue() {
        customers = new ArrayList<>();
    }

    public void addKund(int customersNumber) {
        this.customers.add(customersNumber);
    }

    public int nextKund() {
        return this.customers.remove(0);
    }

    public boolean hasNext() {
        return !this.customers.isEmpty();
    }

    @Override
    public String toString() {
        return this.customers.toString();
    }
}
