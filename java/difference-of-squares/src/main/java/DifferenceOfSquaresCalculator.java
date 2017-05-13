import static java.util.stream.IntStream.rangeClosed;

public final class DifferenceOfSquaresCalculator {
	public int computeSquareOfSumTo(final int upperLimit) {
		return sqr(rangeClosed(1, upperLimit).sum());
	}

	public int computeSumOfSquaresTo(final int upperLimit) {
		return rangeClosed(1, upperLimit).map(this::sqr).sum();
	}

	public int computeDifferenceOfSquares(final int upperLimit) {
		return computeSquareOfSumTo(upperLimit)
			- computeSumOfSquaresTo(upperLimit);
	}

	private int sqr(final int number) {
		return number * number;
	}
}
