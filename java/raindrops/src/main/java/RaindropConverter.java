import com.google.common.collect.ImmutableMap;
import java.util.Optional;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.joining;

public class RaindropConverter {
	private static final ImmutableMap<Integer, String> REPLACEMENTS =
		ImmutableMap.<Integer, String>builder()
		.put(3, "Pling")
		.put(5, "Plang")
		.put(7, "Plong")
		.build();

	public String convert(final int number) {
		return Optional.of(byReplacements(number))
			.filter(s -> !s.isEmpty())
			.orElseGet(() -> Integer.toString(number));
	}

	private String byReplacements(final int number) {
		return REPLACEMENTS.entrySet().stream()
			.filter(repl -> number % repl.getKey() == 0)
			.map(Entry::getValue)
			.collect(joining());
	}
}
