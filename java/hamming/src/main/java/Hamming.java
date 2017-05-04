import static java.util.stream.IntStream.range;

public class Hamming {
	private final String firstWord;
	private final String secondWord;

	public Hamming(final String firstWord, final String secondWord) {
		this.firstWord = firstWord;
		this.secondWord = secondWord;

		validateArguments();
	}

	private void validateArguments() {
		if (firstWord == null
			|| secondWord == null
			|| firstWord.length() != secondWord.length()) {

			throw new IllegalArgumentException();
		}
	}

	public int getHammingDistance() {
		return (int)
			range(0, firstWord.length())
			.filter(this::differsAtIndex)
			.count();
	}

	private boolean differsAtIndex(final int idx) {
		return firstWord.charAt(idx) != secondWord.charAt(idx);
	}
}
