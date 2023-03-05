package Main;

import Shop.*;
import System.*;

public class RunSim {
	public static void main(String[] args){
		ShopState shopState = new ShopState();
		ButikView shopView = new ButikView(shopState);
		shopState.open = true;

		EventQueue eventQueue = new EventQueue(shopState);
		StartSim startSim = new StartSim(0, eventQueue);
		StopSim stopSim = new StopSim(999, eventQueue);
		Closing closing = new Closing(10, eventQueue);

		Simulator sim = new Simulator(shopState, eventQueue);
	}
}
