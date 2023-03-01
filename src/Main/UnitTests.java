package Main;

import java.util.Observable;

import Shop.*;
import Simulator.*;

public class UnitTests{

	private static int STARTTIME = 0;
	private static int STOPTIME = 999;

	// Must be a static class or there's going to be an error in main().
	private static class TestView extends View {
		public int updates = 0; // Count number of times that update() was run
		public TestView(State st) {
			super(st);
		}
		public void update(Observable obs, Object obj) {
			updates++;
			System.out.println("OBS: " + obs + "\tOBJ: " + obj);
		}
	}

	public static void main(String[] args){
		System.out.println("Running unit tests...");
		// Have to test the Simulator pkg first (since Shop pkg depends on it).

		// State test
		State st = new State();
		assert st.isStopped() == false;
		st.stop();
		assert st.isStopped() == true;
		assert st.getTime() == 0;

		// EventQueue test
		EventQueue evq = new EventQueue(st);
		assert evq.hasNext() == false;

		// StartSim test
		StartSim evStart = new StartSim(STARTTIME, evq);
		evq.addEvent(evStart);
		assert evq.hasNext() == true;
		Event ev = evq.nextEvent();
		assert evq.hasNext() == false;
		assert ev != null;
		assert ev.getClass().equals(evStart.getClass());
		StartSim evStartTest = (StartSim) ev;
		assert evStartTest.equals(evStart);

		// StopSim test
		StopSim evStop = new StopSim(STOPTIME, evq);
		evq.addEvent(evStop);
		assert evq.hasNext() == true;
		ev = evq.nextEvent();
		assert evq.hasNext() == false;
		assert ev != null;
		assert ev.getClass().equals(evStop.getClass());
		StopSim evStopTest = (StopSim) ev;
		assert evStopTest.equals(evStop);

		// View test
		st = new State(); // Resets the state
		TestView tv = new TestView(st);
		assert tv.updates == 0;
		evStart.execute(st);
		assert st.isStopped() == false;
		assert st.getTime() == STARTTIME;
		assert tv.updates == 1;
		evStop.execute(st);
		assert st.isStopped() == true;
		assert st.getTime() == STOPTIME;
		assert tv.updates == 2;

		// ButikState butikState = new ButikState();
		// ButikView butikView = new ButikView(butikState);
		// butikState.open = true;
		// Closing closing = new Closing(10, eventQueue);
		// Simulator sim = new Simulator(butikState, eventQueue);

		System.out.println("Tests OK");
	}
}
