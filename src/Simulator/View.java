package Simulator;

import java.util.Observable;
import java.util.Observer;

public abstract class View implements Observer {
	public View(State state) {
		state.addObserver(this);
	}

	public abstract void update(Observable observable, Object object);
}
