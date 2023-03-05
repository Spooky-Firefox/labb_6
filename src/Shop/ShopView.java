package Shop;

import java.util.Observable;

import System.State;
import System.View;
import System.Event;

public class ShopView extends View {
	public ShopView(State state) {
		super(state);
	}

	// TODO: columns might need adjusting, using \t tabs in the strings.

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
		// TODO: might need column adjustments...
		System.out.println("Tid Handelse  Kund  ?  led  ledT  I  $  :-(  koat  koT  koar  [Kassako..]");
	}

	private void printStop(ShopState state) {
		System.out.println("\nRESULTAT\n========\n");
		System.out.println("1) Av " + state.maxCustomers + " kunder handlade " +
			state.getCustomersPayed() + " medan " +
			state.getCustomersMissed() + " missades.\n");

		System.out.println("2) Total tid " + state.openCheckouts + " kassor varit lediga: " +
			state.getTimeEmptyCheckouts() + " te.");
		// Yeah no, no idea what kind of unit te is..

		// TODO: STAT VARS for these last lines!
		System.out.println("   Genomsnittlig ledig kassatid: " + 0 +
			" (dvs " + 0 + "% av tiden fran oppning tills sista kunden betalat).\n");

		System.out.println("3) Total tid " + state.maxCustomers + " kunder tvingats koa: " +
			0 + " te.");
		System.out.println("   Genomsnittlig kotid: " + 0 + " te.");
	}

	private void printEvent(ShopState state, ShopEvent event) {
		// It's gonna be a big one..
		System.out.println(event.prettyStartTime() + "  " + event + "   " +
			event.getCustomer() + "     " + state.prettyOpen() + "  " +
			state.freeCheckouts() + "   " + state.getTimeEmptyCheckouts() + "   " +
			state.getShoppingCustomers() + " " + state.getCustomersPayed() + "  " +
			state.getCustomersMissed() + "    " + state.getCustomersWaited() + "     " +
			state.getTimeWaitingCustomers() + "  " + state.getCheckoutLength() + "     " +
			state.prettyCheckout()
		);
	}

	@Override
	public void update(Observable obs, Object obj) {
		// obs: a ShopState instance
		// obj: ShopEvent to be executed next

		// TODO: assure obs really is a ShopState???
		ShopState state = (ShopState) obs;
		String event = obj.getClass().toString();

		switch (event) {
			case "class Shop.EventStart":
				printStart(state);
				System.out.println(((Event) obj).prettyStartTime() + "   Start");
				break;
			case "class System.StopSim":
				System.out.println(((Event) obj).prettyStartTime() + "   Stop");
				printStop(state);
				break;
			case "class Shop.EventArrival", "class Shop.EventPick",
				"class Shop.EventPayment", "class Shop.EventClosing":
				printEvent(state, (ShopEvent) obj);
				break;
			default:
				System.out.println("Unhandled event: " + obj.getClass());
				break;
		}
	}
}
