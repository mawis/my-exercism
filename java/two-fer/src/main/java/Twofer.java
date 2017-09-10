import static java.util.Optional.ofNullable;

public class Twofer {
	private static final String MESSAGE = "One for %s, one for me.";
	private static final String DEFAULT_NAME = "you";

	public String twofer(final String name) {
		return String.format(MESSAGE, ofNullable(name).orElse(DEFAULT_NAME));
	}
}
