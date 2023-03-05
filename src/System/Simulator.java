package System;


public class Simulator {
	private State state;
	private EventQueue events;

	public Simulator(State state, EventQueue events) {
		this.state = state;
		this.events = events;
	}

	public void runLoop() {
		while (events.hasNext()){
			if (state.isStopped()) {
				System.out.println("Simulation: STOPPED");
				return;
			}

			Event currentEvent = events.nextEvent();
			state.notify(currentEvent);
			state.setTime(currentEvent.getStartTime());
			currentEvent.execute(state);
		}
	}
}
