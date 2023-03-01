package Simulator;

import java.util.Observable;

public class State extends Observable {
	private boolean stopSimulation;
	private int currentTime;

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

	public void setTime(int newTime) {
		this.currentTime = newTime;
	}

	public int getTime() {
		return this.currentTime;
	}
}
