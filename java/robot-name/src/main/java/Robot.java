import java.util.Random;

public class Robot {
	private static final Random RNG = new Random();
	private static final String NAME_PATTERN = "%c%c%03d";

	@lombok.Getter
	private String name;

	public Robot() {
		reset();
	}

	public void reset() {
		name = generateName();
	}

	private static String generateName() {
		return formattedName(Math.abs(RNG.nextInt()));
	}

	private static String formattedName(final int id) {
		return String.format(
				NAME_PATTERN,
				'A' + id / 26000 % 26,
				'A' + id / 1000 % 26,
				id % 1000);
	}
}
