package Simulator;

public class StartSim extends Event {
	//behöver fixa att tiden är med i state
	//execute(state);

	public StartSim(int time, EventQueue eventQueue) {
		super(time, eventQueue);
	}

	@Override
	public void execute(State state) {
	}
}
