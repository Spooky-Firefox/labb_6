package Simulator;

import java.util.Observable;

public class State extends Observable {
	private boolean stopSimulation;
	private int currentTime;

	public void stop() {
	}

	public boolean isStopped() {
		return false;
	}

	public int getTime() {
		return 0;
	}
}
