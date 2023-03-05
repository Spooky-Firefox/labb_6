package Shop;

import java.util.Observable;

import System.State;
import System.View;

public class ShopView extends View
{
	public ShopView(State state) {
		super(state);
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
		System.out.println("Tid Handelse  Kund  ?  led  ledT  I  $  :-(  koat  koT  koar  [Kassako..]");
	}

	private void printStop(ShopState state) {
		System.out.println("\nRESULTAT\n========\n");
		System.out.println("1) Av " + state.maxCustomers + " kunder handlade " +
			state.customersPayed + " medan " +
			state.customersMissed + " missades.\n");

		System.out.println("2) Total tid " + state.openCheckouts + " kassor varit lediga: " +
			state.timeEmptyCheckouts + " te."); // Yeah no, no idea what kind of unit te is

		// TODO: STAT VARS for these last lines!
		System.out.println("   Genomsnittlig ledig kassatid: " + 0 +
			" (dvs " + 0 + "% av tiden fran oppning tills sista kunden betalat).\n");

		System.out.println("3) Total tid " + state.maxCustomers + " kunder tvingats koa: " +
			0 + " te.");
		System.out.println("   Genomsnittlig kotid: " + 0 + " te.");
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
				break;
			case "class System.StopSim":
				printStop(state);
				break;
			default:
				System.out.println("Unhandled event: " + obj.getClass());
				break;
		}
	}
}
