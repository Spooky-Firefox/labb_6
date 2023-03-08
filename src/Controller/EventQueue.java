package Controller;

import java.util.ArrayList;

/**
 * A class that keeps track of the upcoming events
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class EventQueue {
	ArrayList<Event> list;
	State state;

	/**
	 * Creates the EventQueue object, where the state provides the current time
	 * @param state the accompanying state
	 */
	public EventQueue(State state){
		this.state = state;
		this.list = new ArrayList<>();
	}

	/**
	 * Add an event to the event queue
	 * throw an IllegalArgumentException if the event would happen before our current time.
	 * "time travel is forbidden"
	 * @param event the event to add
	 */
	public void addEvent(Event event) {
		// throw error if the time is in the past
		if (event.getStartTime() < this.state.getTime()){
			throw new IllegalArgumentException("Can't add a event that happens in the past");
		}

		// if the queue is empty add the event
		if (list.size() == 0) {
			list.add(event);
			return;
		}

		// if the event is after the last element
		if (event.getStartTime() > list.get(list.size() - 1).getStartTime()) {
			list.add(event);
			return;
		}

		// if the event is before last element,
		// find which is right after and add it att that index
		for (int i = 0; i < list.size(); i++) {
			if (event.getStartTime() < list.get(i).getStartTime()) {
				list.add(i, event);
				break;
			}
		}
	}

	/**
	 * return the next element in the que, tho one that should happen next
	 * @return the next element
	 */
	Event nextEvent() {
		if (hasNext()) {
			return list.remove(0);
		}
		return null;
	}

	/**
	 * if there is a next element in the queue
	 * @return return true if there are a next element in queue
	 */
	boolean hasNext() {
		return !list.isEmpty();
	}
}
