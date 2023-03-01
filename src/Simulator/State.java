package Simulator;

import java.util.Observable;

public class State extends Observable {
	private boolean stopSimulation;
	private int currentTime;

	public void stop() {
		this.stopSimulation = true;
		this.setChanged();
		this.notifyObservers();
	}

	public boolean isStopped() {
		return this.stopSimulation;
	}

	public void setTime(int newTime) {
		this.currentTime = newTime;
		this.setChanged();
		this.notifyObservers();
	}

	public int getTime() {
		return this.currentTime;
	}
}
