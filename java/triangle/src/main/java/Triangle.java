import com.google.common.collect.ImmutableList;
import java.util.stream.DoubleStream;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class Triangle {
	private final ImmutableList<Double> sides;

	public Triangle(
			final double a,
			final double b,
			final double c)
		throws TriangleException {

		sides = DoubleStream.of(a, b, c)
			.sorted()
			.boxed()
			.collect(toImmutableList());

		validate();
	}

	public TriangleKind getKind() {
		final long differentLengths = sides.stream().distinct().count();

		return differentLengths == 1 ? TriangleKind.EQUILATERAL
			: differentLengths == 2 ? TriangleKind.ISOSCELES
			: TriangleKind.SCALENE;
	}

	private void validate() throws TriangleException {
		if (sides.stream().anyMatch(side -> side <= 0)
			|| sides.get(0) + sides.get(1) <= sides.get(2)) {
			throw new TriangleException();
		}
	}
}
