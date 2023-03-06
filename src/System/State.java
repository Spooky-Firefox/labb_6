package Simulator;

import java.util.Observable;

public class State extends Observable {
	private boolean stopSimulation;
	protected double currentTime;

	// Notify any observers (for example View or ShopView)
	public void notify(Event ev) {
		this.setChanged();
		this.notifyObservers(ev);
	}

	public void stop() {
		this.stopSimulation = true;
	}

	public boolean isStopped() {
		return this.stopSimulation;
	}

	public void setTime(double newTime) {
		this.currentTime = newTime;
		this.setChanged();
		this.notifyObservers();
	}

	public double getTime() {
		return this.currentTime;
	}
}
