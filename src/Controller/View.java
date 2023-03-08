package Controller;

import java.util.Observable;
import java.util.Observer;

/**
 * A view which observes state and runs a function when the state was updated.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public abstract class View implements Observer {
	/**
	 * Constructor. Adds itself as an observer to state
	 * @param state the state to observe
	 */
	public View(State state) {
		state.addObserver(this);
	}

	// obs will contain a state instance, obj will contain an event instance

	/**
	 * abstract method which is called whenever state was changed.
	 * @param obs the observable object (ie, a State object)
	 * @param obj free object to pass to the method (usually events are passed in)
	 */
	public abstract void update(Observable obs, Object obj);
}
