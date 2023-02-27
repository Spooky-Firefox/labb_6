package Simulator;

public class Simulator 
{
	private State state;
	private EventQueue events[];
	
	public Simulator(State state, EventQueue[] events) //Är detta fel?
	{
		this.state = state;
		this.events = events;
	}
	
	public void runLoop()
	{
		
	}
}
