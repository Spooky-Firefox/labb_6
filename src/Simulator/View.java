package Simulator;

import java.util.Observable;
import java.util.Observer;

public abstract class View implements Observer {
	public View(State state) {
		state.addObserver(this);
	}

	// obs will contain a state instance, obj will contain an event instance
	public abstract void update(Observable obs, Object obj);
}
