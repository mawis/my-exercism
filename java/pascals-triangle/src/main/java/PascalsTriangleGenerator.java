import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.*;

public class PascalsTriangleGenerator {
	public int[][] generateTriangle(final int rows) {
		return triangle()
			.limit(rows)
			.toArray(r -> new int[r][]);
	}

	private static Stream<int[]> triangle() {
		return Stream.iterate(new int[]{1}, PascalsTriangleGenerator::next);
	}

	private static int[] next(final int[] prev) {
		return enclosed(
				range(0, prev.length - 1)
				.map(i -> prev[i] + prev[i + 1]))
			.toArray();
	}

	private static IntStream enclosed(final IntStream stream) {
		return concat(concat(IntStream.of(1), stream), IntStream.of(1));
	}
}
