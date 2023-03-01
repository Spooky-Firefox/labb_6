package Simulator;


public class Simulator {
	private State state;
	private EventQueue events;

	public Simulator(State state, EventQueue events) {
		this.state = state;
		this.events = events;
	}

	public void RunLoop() {
		while(state.isStopped() == false) {
			Event CurrentEvent = events.nextEvent();
			state.setTime(CurrentEvent.getStartTime());
			CurrentEvent.execute(state);
			if (!events.hasNext()) {
				System.out.println("event was null");
				state.stop();
			}
		}
	}
}
