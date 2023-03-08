package Controller;

import java.util.Observable;

/**
 * A class which purpose is to keep track of the state of the simulation,
 * with variables like current time
 *
 * State is Observable
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class State extends Observable {
	/**
	 * Tracks the current time in the simulation.
	 */
	protected double currentTime;
	private boolean stopSimulation;

	/**
	 * Constructor.
	 */
	public State() {
		this.currentTime = 0;
		this.stopSimulation = false;
	}

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
