import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.function.UnaryOperator;

import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.Iterables.concat;
import static java.util.stream.IntStream.rangeClosed;

final class HandshakeCalculator {
    private static final
	ImmutableMap<Integer, UnaryOperator<ImmutableList<Signal>>> ENCODINGS =
	ImmutableMap.of(0, append(Signal.WINK),
			1, append(Signal.DOUBLE_BLINK),
			2, append(Signal.CLOSE_YOUR_EYES),
			3, append(Signal.JUMP),
			4, ImmutableList::reverse);

    public ImmutableList<Signal> calculateHandshake(final int number) {
	return rangeClosed(0, 4)
	    .filter(bit -> (number & (1 << bit)) != 0)
	    .mapToObj(ENCODINGS::get)
	    .reduce(of(),
		    (accu, next) -> next.apply(accu),
		    (left, right) -> copyOf(concat(left, right)));
    }

    private static UnaryOperator<ImmutableList<Signal>> append(final Signal s) {
	return list -> copyOf(concat(list, of(s)));
    }
}
