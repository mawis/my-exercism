import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;

import static com.google.common.collect.ImmutableList.toImmutableList;

public class Matrix {
	private static final String LF = "\n";
	private static final String SPACE = " ";
	private static final int EMPTY = 0;
	private final ImmutableList<ImmutableList<Integer>> vals;

	public Matrix(final String matrixString) {
		vals = Stream.of(matrixString.split(LF))
			.map(Matrix::convertLineString)
			.collect(toImmutableList());
	}

	public int getRowsCount() {
		return vals.size();
	}

	public int getColumnsCount() {
		return vals.stream().findFirst().map(ImmutableList::size).orElse(EMPTY);
	}

	public int[] getRow(final int i) {
		return asArray(vals.get(i));
	}

	public int[] getColumn(final int i) {
		return asArray(
				vals.stream()
				.map(row -> row.get(i))
				.collect(toImmutableList()));
	}

	private static int[] asArray(final ImmutableList<Integer> list) {
		final int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private static ImmutableList<Integer> convertLineString(final String line) {
		return Stream.of(line.split(SPACE))
			.map(Integer::valueOf)
			.collect(toImmutableList());
	}
}
