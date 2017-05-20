import com.google.common.collect.ImmutableList;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

public class TwelveDays {
	private static final ImmutableList<String> ORDINALS = ImmutableList.of(
			"first", "second", "third", "fourth", "fifth", "sixth",
			"seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth");
	private static final ImmutableList<String> GIFTS = ImmutableList.of(
			"a Partridge in a Pear Tree.",
			"two Turtle Doves, and",
			"three French Hens,",
			"four Calling Birds,",
			"five Gold Rings,",
			"six Geese-a-Laying,",
			"seven Swans-a-Swimming,",
			"eight Maids-a-Milking,",
			"nine Ladies Dancing,",
			"ten Lords-a-Leaping,",
			"eleven Pipers Piping,",
			"twelve Drummers Drumming,");
	private static final String INTRO =
		"On the %s day of Christmas my true love gave to me, ";
	private static final String SPACE = " ";
	private static final String LF = "\n";

	public String verse(final int num) {
		return rangeClosed(1, num)
			.map(i -> num - i)
			.mapToObj(GIFTS::get)
			.collect(
					joining(
							SPACE,
							String.format(INTRO, ORDINALS.get(num - 1)),
							LF));
	}

	public String verses(final int from, final int to) {
		return rangeClosed(from, to)
			.mapToObj(this::verse)
			.collect(joining(LF));
	}

	public String sing() {
		return verses(1, 12);
	}
}
