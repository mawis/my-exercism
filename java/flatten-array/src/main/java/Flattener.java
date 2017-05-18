import com.google.common.collect.ImmutableList;
import java.util.List;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.stream.Stream.of;

final class Flattener {
	public ImmutableList<?> flatten(List<?> input) {
		return input.stream()
			.filter(e -> e != null)
			.flatMap(el -> el instanceof List ? flatten((List) el).stream() : of(el))
			.collect(toImmutableList());
	}
}
