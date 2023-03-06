package Shop;

import java.util.Observable;

import Controller.State;
import Controller.View;
import Controller.Event;

public class ShopView extends View {
	public ShopView(State state) {
		super(state);
	}

	// TODO: columns might need adjusting, using \t tabs in the strings.
	// This whole file is a fucking mess.
	private String pad12(String string){
		String out = string;
		for (int i = string.length(); i < 12; i++) {
			out = out+" ";
		}
		return out;
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
		// TODO: might need column adjustments...
		System.out.println("Tid\t\tHandelse\tKund\t?\tled\tledT\tI\t$\t:-(\tkoat\tkoT\t\tkoar [Kassako..]");
	}

	private void printStop(ShopState state) {
		System.out.println("\nRESULTAT\n========\n");
		System.out.println("1) Av " + state.maxCustomers + " kunder handlade " +
			state.customersPayed + " medan " +
			state.customersMissed + " missades.\n");

		System.out.println("2) Total tid " + state.openCheckouts + " kassor varit lediga: " +
			state.timeEmptyCheckouts + " te.");
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
		System.out.printf("%s\t%s%s\t\t%s\t%d\t%.2f\t%d\t%d\t%d\t%d\t\t%.2f\t%d\t%s\n",
			event.prettyStartTime(),pad12(event.toString()),event.prettyCustomer(),  // time event-name customerNr
			state.prettyOpen(),state.checkoutQueue.noFree(),state.timeEmptyCheckouts, // open, freecheakouts, time empty cheakouts
			state.shoppingCustomers,state.customersPayed,state.customersMissed, state.customersWaited,
			state.timeWaitingCustomers, state.checkoutQueue.size(),state.checkoutQueue.toString()
			);
	}

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
				System.out.println(event.prettyStartTime() + "  " + event);
				break;
			case "class Shop.ShopStop":
				System.out.println(event.prettyStartTime() + "  " + event);
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
}
