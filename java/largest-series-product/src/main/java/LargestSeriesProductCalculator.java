import com.google.common.collect.ImmutableList;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.stream.IntStream.rangeClosed;

public class LargestSeriesProductCalculator {
	private static final String NON_NULL_REQUIRED =
		"String to search must be non-null.";
	private static final String ONLY_DIGITS =
		"String to search may only contains digits.";
	private static final String NEGATIVE_LENGTH =
		"Series length must be non-negative.";
	private static final String SERIES_TOO_BIG =
		"Series length must be less than or equal to the length "
		+ "of the string to search.";

	private final ImmutableList<Integer> digits;

	public LargestSeriesProductCalculator(final String input) {
		checkArgument(input != null, NON_NULL_REQUIRED);
		checkArgument(input.chars().allMatch(Character::isDigit), ONLY_DIGITS);

		digits = input.chars()
			.map(Character::getNumericValue)
			.boxed()
			.collect(toImmutableList());
	}

	public long calculateLargestProductForSeriesLength(final int seriesLength) {
		checkArgument(seriesLength <= digits.size(), SERIES_TOO_BIG);
		checkArgument(seriesLength >= 0, NEGATIVE_LENGTH);

		return rangeClosed(0, digits.size() - seriesLength)
			.mapToObj(i -> digits.subList(i, i + seriesLength))
			.mapToLong(this::serieProduct)
			.max().getAsLong();
	}

	private long serieProduct(final ImmutableList<Integer> serie) {
		return serie.stream()
			.mapToLong(Integer::longValue)
			.reduce(1L, (a, b) -> a * b);
	}
}
