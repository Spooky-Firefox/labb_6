package Simulator;

import java.util.ArrayList;

public class EventQueue {
	ArrayList<Integer> list = new ArrayList<>();

	public void addEvent(Event event) {
		list.append(event);
	}

	public Event nextEvent() {
		return null;
	}

	public boolean hasNext() {
		return false;
	}
}
