package Simulator;

import java.util.Observable;

public class State extends Observable {
	private boolean stopSimulation;
	private int currentTime;

	public void stop() {
		this.stopSimulation = true;
	}

	public boolean isStopped() {
		return this.stopSimulation;
	}

	public int getTime() {
		return this.currentTime;
	}
}
