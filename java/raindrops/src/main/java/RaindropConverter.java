import com.google.common.collect.ImmutableMap;
import java.util.Optional;

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
		return REPLACEMENTS.keySet().stream()
			.filter(divisor -> number % divisor == 0)
			.map(REPLACEMENTS::get)
			.reduce(String::concat);
	}
}
