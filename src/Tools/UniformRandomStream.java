package Tools;

import java.util.Random;

/**
 * Random Number Generator with uniform distribution.
 * @author Kalle Hedberg, David Malmblad, Olle Ronstad, Alexander Svensson.
 */
public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * Constructor.
	 * @param lower min range of generated numbers
	 * @param upper max range of generated numbers
	 * @param seed value to seed the RNG
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper-lower;
	}

	/**
	 * Constructor.
	 * @param lower min range of generated numbers
	 * @param upper max range of generated numbers
	 */
	public UniformRandomStream(double lower, double upper) {
		rand = new Random();
		this.lower = lower;
		this.width = upper-lower;
	}

	/**
	 * next returns a new, random number within the set range.
	 * @return a random number
	 */
	public double next() {
		return lower+rand.nextDouble()*width;
	}
}

