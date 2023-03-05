package Main;

import Shop.*;
import System.*;

public class RunSim {
	public static void main(String[] args){
		ShopState shopState = new ShopState();
		ShopView shopView = new ShopView(shopState);

		EventQueue eventQueue = new EventQueue(shopState);
		StartSim startSim = new StartSim(0, eventQueue);
		StopSim stopSim = new StopSim(999, eventQueue);
		EventClosing closing = new EventClosing(10, eventQueue);

		Simulator sim = new Simulator(shopState, eventQueue);
	}
}
