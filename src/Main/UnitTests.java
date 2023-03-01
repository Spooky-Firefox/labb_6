package Main;

import java.util.Observable;
import Simulator.*;
import Butik.*;

public class UnitTests{

	private static int STARTTIME = 0;
	private static int STOPTIME = 999;

	// Måste vara en static class, annars får man error i main() (som är static).
	private static class TestView extends View {
		public int updates = 0; // Räknar antalet gånger som update() har körts
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
		// Börjar först med att testa simulator pkg (då butik pkg är beroende av simulator)

		// EventQueue test
		EventQueue evq = new EventQueue();
		assert evq.hasNext() == false;

		// StartSim test
		// Konstruktor bör lägga till event i eventqueue automatiskt
		StartSim evStart = new StartSim(STARTTIME, evq);
		assert evq.hasNext() == true;
		Event ev = evq.nextEvent();
		assert evq.hasNext() == false;
		assert ev != null;
		assert ev.getClass().equals(evStart.getClass());
		StartSim evStartTest = (StartSim) ev;
		assert evStartTest.equals(evStart);

		// StopSim test
		StopSim evStop = new StopSim(STOPTIME, evq);
		assert evq.hasNext() == true;
		ev = evq.nextEvent();
		assert evq.hasNext() == false;
		assert ev != null;
		assert ev.getClass().equals(evStop.getClass());
		StopSim evStopTest = (StopSim) ev;
		assert evStopTest.equals(evStop);

		// State test
		State st = new State();
		assert st.isStopped() == false;
		st.stop();
		assert st.isStopped() == true;
		assert st.getTime() == 0;

		// View test
		st = new State(); // För att återställa stop
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
		// butikState.öppen = true;
		// Stängning stängning = new Stängning(10, eventQueue);
		// Simulator sim = new Simulator(butikState, eventQueue);

		System.out.println("Tests OK");
	}
}
