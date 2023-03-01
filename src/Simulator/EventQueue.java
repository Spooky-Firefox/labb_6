package Simulator;

import java.util.ArrayList;

public class EventQueue {
	ArrayList<Event> list = new ArrayList<>();

	public void addEvent(Event event) {
		list.add(event);
	}

	public Event nextEvent() {
		return null;
	}

	public boolean hasNext() {
		return false;
	}
}
