import java.util.Optional;
import java.util.function.Predicate;

public class HelloWorld {
	private static final String GREETING = "Hello, %s!";
	private static final String DEFAULT = "World";

	public static String hello(final String name) {
		return String.format(GREETING, defaulted(name));
	}

	private static String defaulted(final String name) {
		return
			Optional.ofNullable(name)
			.filter(((Predicate<String>) String::isEmpty).negate())
			.orElse(DEFAULT);
	}
}
