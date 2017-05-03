import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class PangramChecker {
	private static final int NOT_IN_STRING = -1;
	private static final int FIRST_CHARACTER = 'a';
	private static final int AFTER_LAST_CHARACTER = 'z' + 1;

	public boolean isPangram(final String input) {
		return everyLetter().allMatch(isContainedIn(input.toLowerCase()));
	}

	private IntPredicate isContainedIn(final String testedString) {
		return ch -> testedString.indexOf(ch) != NOT_IN_STRING;
	}

	private IntStream everyLetter() {
		return range(FIRST_CHARACTER, AFTER_LAST_CHARACTER);
	}
}
