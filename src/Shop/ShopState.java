package Shop;

import Simulator.State;
import Tools.ExponentialRandomStream;
import Tools.UniformRandomStream;

public class ShopState extends State {
    private int deltaTime;
    public CheckoutQueue queue;
    public int checkouts;
    public int freeCheckouts;
    public int shopCapacity;
    public int customersInStore;
    public int amountOfCustomersHaveQueued;
    public int servedCustomers;
    public int missedCustomers;
    public int checkoutFreeTime;
    public int totalAmountOfTimeInQueue;
    public boolean open;

    public UniformRandomStream uRandStream;
    public ExponentialRandomStream eRandStream;

    public void ShopState(int checkouts, int shopCapacity, long seed) {
        currentTime = 0;

        this.checkouts = checkouts;
        this.freeCheckouts = checkouts;
        this.queue = new CheckoutQueue();

        this.amountOfCustomersHaveQueued = 0;
        this.checkoutFreeTime = 0;
        this.totalAmountOfTimeInQueue = 0;

        this.shopCapacity = shopCapacity;
        this.customersInStore = 0;

        this.servedCustomers = 0;
        this.missedCustomers = 0;

        //TODO fix lambda upper and lowe
        this.eRandStream = new ExponentialRandomStream(0.1, seed);
        this.uRandStream = new UniformRandomStream(0, 1, seed);

    }

    public void updateStatistics() {
        // TODO implement updating of statistics and notify observers of such change
        // sum of time of empty checkouts
        // sum of total time in checkout queue
        // for the sum of checkout queue time and total time of empty checkouts
        // delta time is required
        // a example of calculating the sum queue time
        // queueTime = queueTime + checkoutQueue.size()*deltaTime
    }

    @Override
    public void setTime(int newTime) {
        this.deltaTime = newTime - this.currentTime;
        super.setTime(newTime);
    }
}
