package Simulator;

import java.util.ArrayList;

public class EventQueue {
	ArrayList<Event> list = new ArrayList<>();

	public void addEvent(Event event) {
		// TODO throw error if the time is in the past
		if(list.size()==0){
			list.add(event);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if(event.getStartTime()<list.get(i).getStartTime()){
					list.add(i,event);
					break;
				}
			}
		}
	}

	public Event nextEvent() {
		return list.remove(0);
	}

	public boolean hasNext() {
		return list.isEmpty();
	}
}
