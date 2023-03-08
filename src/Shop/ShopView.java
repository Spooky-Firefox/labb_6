package Shop;

import java.util.Observable;

import Controller.State;
import Controller.View;
import Controller.Event;

// This whole file is a fucking mess.

/**
 * ShopView extends the public View class and prints out params, events and stats from
 * simulating a shop using this package.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
@SuppressWarnings("SpellCheckingInspection")
public class ShopView extends View {

	/**
	 * Constructor.
	 * @param state an instance of the public State class.
	 */
	public ShopView(State state) {
		super(state);
	}

	/**
	 * update is called using the observer pattern (and thus has to be public)
	 * everytime we want to print a shop event that's currently running.
	 * @param obs instance of State
	 * @param obj instance of currently running event
	 */
	@Override
	public void update(Observable obs, Object obj) {
		// obs: a ShopState instance
		// obj: ShopEvent to be executed next

		// TODO: assure obs and obj really is ShopState and Event/ShopEvent???
		ShopState state = (ShopState) obs;
		String type = obj.getClass().toString();
		Event event = (Event) obj;

		switch (type) {
			case "class Shop.EventStart":
				printStart(state);
				// using format "%9s" the event name will be padded with whitespaces
				// 'till it's 9 letters long (and right justified).
				System.out.println(event.prettyStartTime() + " " + event.prettyName());
				break;
			case "class Controller.StopSim":
				System.out.println(event.prettyStartTime() + " " + event.prettyName());
				printStop(state);
				break;
			case "class Shop.EventArrival", "class Shop.EventPick",
				"class Shop.EventPayment", "class Shop.EventClosing":
				printEvent(state, (ShopEvent) event);
				break;
			default:
				System.out.println("Unhandled event: " + obj.getClass());
				break;
		}
	}

	private String prettyDecimal(double value) {
		return String.format("%.2f", value);
	}

	private void printStart(ShopState state) {
		System.out.println("PARAMETRAR\n==========");
		System.out.println("Antal kassor, N..........: " + state.openCheckouts);
		System.out.println("Max som ryms, M..........: " + state.maxCustomers);
		System.out.println("Ankomsthastighet, lambda.: " + state.arrivalTime);
		System.out.println("Plocktider, [P_min..Pmax]: [" +
			state.pickTimeMin + ".." + state.pickTimeMax + "]");
		System.out.println("Betaltider, [K_min..Kmax]: [" +
			state.paymentTimeMin + ".." + state.paymentTimeMax + "]");
		// BEWARE: Don't change to proper swedish letters for the following rows,
		// or ur going to break shit for everyone else!
		System.out.println("Fro, f...................: " + state.rngSeed);
		System.out.println("\nFORLOPP\n=======");
		System.out.println(
			"Tid\tHandelse Kund\t?\tled\tledT\tI\t$\t:-(\tkoat\tkoT\tkoar\t[Kassako..]"
		);
	}

	private void printStop(ShopState state) {
		System.out.println("\nRESULTAT\n========\n");
		System.out.println(
			"1) Av " + state.customers.total() + " kunder handlade " +
			state.customersPayed + " medan " + state.customersMissed + " missades.\n"
		);
		// Yeah no, no idea what kind of unit te is...
		System.out.println(
			"2) Total tid " + state.openCheckouts + " kassor varit lediga: " +
			prettyDecimal(state.timeEmptyCheckouts) + " te."
		);
		double avgFreeCheckoutTime = state.timeEmptyCheckouts/state.openCheckouts;
		System.out.printf(
			"   Genomsnittlig ledig kassatid: %.2f (dvs %.2f%% av tiden fran oppning tills sista kunden betalat).\n\n",
			avgFreeCheckoutTime, (avgFreeCheckoutTime*100)/state.lastPay);
		System.out.println(
			"3) Total tid " + state.checkoutQueue.queuedOnce() + " kunder tvingats koa: " +
			prettyDecimal(state.timeWaitingCustomers) + " te."
		);
		System.out.printf("   Genomsnittlig kotid: %.2f te.\n",state.timeWaitingCustomers/state.customersWaited);
	}

	private void printEvent(ShopState state, ShopEvent event) {
		// It's going one big printf...
		System.out.printf("%s %s %s\t%s\t%d\t%.2f\t%d\t%d\t%d\t%d\t%.2f\t%d\t%s\n",
			event.prettyStartTime(),event.prettyName(),event.prettyCustomer(),
			state.prettyOpen(),state.checkoutQueue.amountFree(),state.timeEmptyCheckouts,
			state.customersShopping,state.customersPayed,state.customersMissed,
			state.customersWaited, state.timeWaitingCustomers,
			state.checkoutQueue.queuedCurrent(), state.checkoutQueue.toString()
		);
	}
}
