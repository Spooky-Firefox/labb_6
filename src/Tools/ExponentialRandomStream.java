package Tools;

import java.util.Random;

/**
 * Random Number Generator with uniform distribution.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class ExponentialRandomStream {

	private Random rand;
	private double lambda;

	/**
	 * Constructor.
	 * @param lambda average range of new, randomized numbers
	 * @param seed value to seed the RNG
	 */
	public ExponentialRandomStream(double lambda, long seed) {
		rand = new Random(seed);
		this.lambda = lambda;
	}

	/**
	 * Constructor.
	 * @param lambda average range of new, randomized numbers
	 */
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
		this.lambda = lambda;
	}

	/**
	 * next returns a new, random number within the set range.
	 * @return a random number
	 */
	public double next() {
		return -Math.log(rand.nextDouble())/lambda;
	}
}

