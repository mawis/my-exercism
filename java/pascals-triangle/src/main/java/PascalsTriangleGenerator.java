import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.*;

public class PascalsTriangleGenerator {
	public int[][] generateTriangle(final int row) {
		return toIntArray2D(
				triangle()
				.limit(row)
				.map(PascalsTriangleGenerator::toIntArray)
				.collect(toImmutableList()));
	}

	private static Stream<ImmutableList<Integer>> triangle() {
		return iterate(ImmutableList.of(1), PascalsTriangleGenerator::next);
	}

	private static ImmutableList<Integer> next(final ImmutableList<Integer> prev) {
		return enclosed(
				range(0, prev.size() - 1)
				.mapToObj(i -> prev.get(i) + prev.get(i + 1)))
			.collect(toImmutableList());
	}

	private static Stream<Integer> enclosed(final Stream<Integer> stream) {
		return concat(concat(Stream.of(1), stream), Stream.of(1));
	}

	private static int[] toIntArray(final ImmutableList<Integer> list) {
		final int[] result = new int[list.size()];
		range(0, list.size()).forEach(i -> result[i] = list.get(i));
		return result;
	}

	private static int[][] toIntArray2D(final ImmutableList<int[]> list) {
		final int[][] result = new int[list.size()][];
		range(0, list.size()).forEach(i -> result[i] = list.get(i));
		return result;
	}
}
