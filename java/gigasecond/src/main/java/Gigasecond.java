import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
	private static final long GIGASECOND = 1000000000;
	private final LocalDateTime base;

	public Gigasecond(final LocalDate base) {
		this(base.atStartOfDay());
	}

	public Gigasecond(final LocalDateTime base) {
		this.base = base;
	}

	public LocalDateTime getDate() {
		return base.plusSeconds(GIGASECOND);
	}
}
