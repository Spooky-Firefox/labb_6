package Simulator;

public class StartSim extends Event {
	//beh�ver fixa att tiden �r med i state
	//execute(state);

	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
