package Shop;

import Simulator.State;

public class ShopState extends State
{
	public boolean open;
	public void updateStatistics(){
		// TODO implement updating of statistics and notify observers of such change
		// sum of time of empty checkouts
		// sum of total time in checkout queue
		// for the sum of checkout queue time and total time of empty checkouts
		// delta time is required
		// a example of calculating the sum queue time
		// queueTime = queueTime + checkoutQueue.size()*deltaTime
	}
}
