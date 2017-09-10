/*
 * I have taken this class from my solution of the Sieve
 * problem in Java. But I had to reformulate the recursion
 * in filter(...) to use a while loop instead as Java does
 * not support tail call optimization.
 */
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.ImmutableSet.toImmutableSet;
import static com.google.common.collect.Iterables.concat;
import static java.util.stream.IntStream.rangeClosed;

public class Sieve {
	private static final int FIRST_PRIME = 2;
	@lombok.Getter
	private final ImmutableList<Integer> primes;

	public Sieve(final int size) {
		primes = filter(
				size,
				of(),
				rangeClosed(FIRST_PRIME, size).boxed()
				.collect(toImmutableList()));
	}

	private static ImmutableList<Integer> filter(
			final int size,
			final ImmutableList<Integer> primes,
			final ImmutableList<Integer> candidates) {

		ImmutableList<Integer> primesAccu = primes;
		ImmutableList<Integer> currentCandidates = candidates;

		while (!currentCandidates.isEmpty()) {
			final Integer foundPrime = currentCandidates.get(0);
			final ImmutableList<Integer> primesNext =
				copyOf(concat(primesAccu, of(foundPrime)));
			final ImmutableSet<Integer> noPrimes =
				rangeClosed(2, size/foundPrime)
				.map(i -> i * foundPrime)
				.boxed()
				.collect(toImmutableSet());
			final ImmutableList<Integer> candidatesNext =
				currentCandidates.subList(1, currentCandidates.size())
				.stream()
				.filter(c -> !noPrimes.contains(c))
				.collect(toImmutableList());

			primesAccu = primesNext;
			currentCandidates = candidatesNext;
		}

		return primesAccu;
	}
}
