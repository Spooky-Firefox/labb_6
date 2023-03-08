package Controller;

import java.util.Observable;

/**
 * A class which purpose is to keep track of the state of the simulation,
 * with variables like current time
 *
 * State is Observable
 * @author Olle Ronstad
 */
public class State extends Observable {
	private boolean stopSimulation;
	protected double currentTime;

	// Notify any observers (for example View or ShopView)

	/**
	 * Notify any observers (for example View or ShopView) with the given envent
	 * @param ev the event to notify observers with
	 */
	public void notifyView(Event ev) {
		this.setChanged();
		this.notifyObservers(ev);
	}

	/**
	 * set the current time of the simulation
	 * @param newTime the new time
	 */
	public void setTime(double newTime) {
		this.currentTime = newTime;
	}

	double getTime() {
		return this.currentTime;
	}

	void stop() {
		this.stopSimulation = true;
	}

	boolean isStopped() {
		return this.stopSimulation;
	}

}
