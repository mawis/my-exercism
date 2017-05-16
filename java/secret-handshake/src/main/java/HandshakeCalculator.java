import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.function.UnaryOperator;

import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.Iterables.concat;
import static java.util.stream.IntStream.range;

final class HandshakeCalculator {
	private static final
		ImmutableMap<Integer, UnaryOperator<ImmutableList<Signal>>> ENCODINGS =
		ImmutableMap.<Integer, UnaryOperator<ImmutableList<Signal>>>builder()
		.put(0, accu -> copyOf(concat(accu, of(Signal.WINK))))
		.put(1, accu -> copyOf(concat(accu, of(Signal.DOUBLE_BLINK))))
		.put(2, accu -> copyOf(concat(accu, of(Signal.CLOSE_YOUR_EYES))))
		.put(3, accu -> copyOf(concat(accu, of(Signal.JUMP))))
		.put(4, ImmutableList::reverse)
		.build();

	public ImmutableList<Signal> calculateHandshake(final int number) {
		return range(0, 5)
			.filter(bit -> (number & (1 << bit)) != 0)
			.mapToObj(ENCODINGS::get)
			.reduce(
					of(),
					(accu, next) -> next.apply(accu),
					(left, right) -> copyOf(concat(left, right)));
	}
}
