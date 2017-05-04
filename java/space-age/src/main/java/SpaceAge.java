public class SpaceAge {
	private static final double YEAR_IN_SECONDS = 31557600;
	private final long ageInSeconds;

	public SpaceAge(final long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	public long getSeconds() {
		return ageInSeconds;
	}

	public double onEarth() {
		return ageInSeconds / YEAR_IN_SECONDS;
	}

	public double onMercury() {
		return on(Planet.MERCURY);
	}

	public double onVenus() {
		return on(Planet.VENUS);
	}

	public double onMars() {
		return on(Planet.MARS);
	}

	public double onJupiter() {
		return on(Planet.JUPITER);
	}

	public double onSaturn() {
		return on(Planet.SATURN);
	}

	public double onUranus() {
		return on(Planet.URANUS);
	}

	public double onNeptune() {
		return on(Planet.NEPTUNE);
	}

	private double on(final Planet p) {
		return onEarth() / p.orbitalPeriod;
	}

	private static enum Planet {
		MERCURY(0.2408467),
		VENUS(0.61519726),
		EARTH(1.0),
		MARS(1.8808158),
		JUPITER(11.862615),
		SATURN(29.447498),
		URANUS(84.016846),
		NEPTUNE(164.79132);

		public final double orbitalPeriod;

		private Planet(final double orbitalPeriod) {
			this.orbitalPeriod = orbitalPeriod;
		}
	}
}
