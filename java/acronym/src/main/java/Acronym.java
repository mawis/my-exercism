import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Acronym {
	private final Pattern WORD_PATTERN = Pattern.compile("\\W+");
	private final String phrase;

	public Acronym(final String phrase) {
		this.phrase = phrase;
	}

	public String get() {
		return words().map(Acronym::shortenWord).collect(joining());
	}

	private Stream<String> words() {
		return WORD_PATTERN.splitAsStream(phrase);
	}

	private static String shortenWord(final String word) {
		final String byUppercase = uppercaseLetters(word);
		return haveSameLength(word, byUppercase) || byUppercase.isEmpty() ?
			firstLetterUppercase(word) : byUppercase;
	}

	private static String uppercaseLetters(final String word) {
		return word.chars()
			.filter(c -> c >= 'A' && c <= 'Z')
			.collect(
					StringBuilder::new,
					StringBuilder::appendCodePoint,
					(sbl, sbr) -> sbl.append(sbr))
			.toString();
	}

	private static boolean haveSameLength(final String a, final String b) {
		return a.length() == b.length();
	}

	private static String firstLetterUppercase(final String word) {
		return word.substring(0, 1).toUpperCase();
	}
}
