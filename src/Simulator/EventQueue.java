package Simulator;

import java.util.ArrayList;

public class EventQueue {
    ArrayList<Event> list;
    State state;
    public EventQueue(State state){
        this.state = state;
        this.list = new ArrayList<>();
    }
    public void addEvent(Event event) {
        // throw error if the time is in the past
        if (event.getStartTime() < this.state.getTime()){
            throw new IllegalArgumentException("Can't add a event that happens in the past");
        }
        // if the que is empty add the event
        if (list.size() == 0) {
            list.add(event);

            // if the event is after the last element
        } else if (event.getStartTime() > list.get(list.size() - 1).getStartTime()) {
            list.add(event);

            // if the event is before last element, find which is right after and add it att that index
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (event.getStartTime() < list.get(i).getStartTime()) {
                    list.add(i, event);
                    break;
                }
            }
        }
    }

    public Event nextEvent() {
    	if (hasNext()) {
    		return list.remove(0);
    	}
    	else {
    		return null;
    	}
    }

	public boolean hasNext() {
		return !list.isEmpty();
	}
}
