import com.google.common.collect.ImmutableMap;
import java.util.Optional;

import static java.util.Map.Entry;

public class RaindropConverter {
	private static final ImmutableMap<Integer, String> REPLACEMENTS =
		ImmutableMap.<Integer, String>builder()
		.put(3, "Pling")
		.put(5, "Plang")
		.put(7, "Plong")
		.build();

	public String convert(final int number) {
		return byReplacements(number)
			.orElseGet(() -> Integer.toString(number));
	}

	private Optional<String> byReplacements(final int number) {
		return REPLACEMENTS.entrySet().stream()
			.filter(repl -> number % repl.getKey() == 0)
			.map(Entry::getValue)
			.reduce((a, b) -> a + b);
	}
}
