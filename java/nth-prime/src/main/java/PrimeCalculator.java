import static java.lang.Math.log;

public class PrimeCalculator {
	public int nth(final int n) {
		return new Sieve(estimatePrime(n)).getPrimes().get(n - 1);
	}

	// see https://en.wikipedia.org/wiki/Prime_number_theorem#Approximations_for_the_nth_prime_number
	private int estimatePrime(final int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}

		return n < 6 ? 12
			: (int) (n * (log(n) + log(log(n))));
	}
}
