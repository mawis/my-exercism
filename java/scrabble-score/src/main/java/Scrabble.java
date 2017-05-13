import com.google.common.collect.ImmutableMap;

import static com.google.common.base.Strings.nullToEmpty;
import static java.util.Map.Entry;

public class Scrabble {
	private static final ImmutableMap<String, Integer> POINTS =
		ImmutableMap.<String, Integer>builder()
		.put("AEIOULNRST", 1)
		.put("DG", 2)
		.put("BCMP", 3)
		.put("FHVWY", 4)
		.put("K", 5)
		.put("JX", 8)
		.put("QZ", 10)
		.build();
	private static final int MISSING = -1;
	private static final int NO_POINTS = 0;

	private final String word;

	public Scrabble(final String word) {
		this.word = word;
	}

	public int getScore() {
		return nullToEmpty(word)
			.toUpperCase()
			.chars()
			.map(Scrabble::rateCharacter)
			.sum();
	}

	private static int rateCharacter(final int ch) {
		return POINTS.entrySet().stream()
			.filter(score -> score.getKey().indexOf(ch) != MISSING)
			.mapToInt(Entry::getValue)
			.findFirst()
			.orElse(NO_POINTS);
	}
}
