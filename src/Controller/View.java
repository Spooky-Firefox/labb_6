package Controller;

import java.util.Observable;
import java.util.Observer;

/**
 * A view which observes state
 * @author Olle Ronstad
 */
public abstract class View implements Observer {
	/**
	 * Creates the view and adds itself as an observer to state
	 * @param state the state to observe
	 */
	public View(State state) {
		state.addObserver(this);
	}

	// obs will contain a state instance, obj will contain an event instance

	/**
	 *
	 * @param obs     the observable object.
	 * @param obj   an argument passed to the {@code notifyObservers}
	 *                 method.
	 */
	public abstract void update(Observable obs, Object obj);
}
