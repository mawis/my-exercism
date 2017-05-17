import java.util.stream.IntStream;

public class SumOfMultiples {
	private static final int LIMIT_IS_EXCLUSIVE = 1;
	private final int lastNumber;
	private final int[] factors;

	public SumOfMultiples(final int limit, final int[] factors) {
		this.lastNumber = limit - LIMIT_IS_EXCLUSIVE;
		this.factors = factors;
	}

	public int getSum() {
		return IntStream.of(factors)
			.flatMap(this::multiplies)
			.distinct()
			.sum();
	}

	private IntStream multiplies(final int factor) {
		return IntStream.iterate(factor, n -> n + factor)
			.limit(lastNumber / factor);
	}
}
