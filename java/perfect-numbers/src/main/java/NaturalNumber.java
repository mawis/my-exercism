import static java.util.stream.IntStream.range;

class NaturalNumber {
	private static final String NEGATIVE_NUMBER_MESSAGE =
		"You must supply a natural number (positive integer)";
	private final int number;

	public NaturalNumber(final int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
		}
		this.number = number;
	}

	public Classification getClassification() {
		return classificationForDifference(aliquot(number) - number);
	}

	private static int aliquot(final int num) {
		return range(1, num)
			.filter(n -> num % n == 0)
			.sum();
	}

	private static Classification classificationForDifference(final int diff) {
		return diff == 0 ? Classification.PERFECT
			: diff > 0 ? Classification.ABUNDANT
			: Classification.DEFICIENT;
	}
}
