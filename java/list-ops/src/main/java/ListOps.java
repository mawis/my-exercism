import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListOps {
	private ListOps() {
		// disable construction
	}

	public static <T> int length(final List<T> list) {
		return tail(list).isPresent() ? 1 + length(tail(list).get()) : 0;
	}

	public static <T> List<T> reverse(final List<T> list) {
		return reduce(
				list,
				(List<T>) ImmutableList.of(),
				ListOps::prepend,
				null);
	}

	public static <T> List map(final List<T> list, final Function<T, T> f) {
		return head(list).isPresent()
			? prepend(map(tail(list).get(), f), f.apply(head(list).get()))
			: ImmutableList.of();
	}

	public static <T> List filter(final List<T> list, final Predicate<T> p) {
		System.out.println("filter: " + list);
		System.out.println("head: " + head(list));
		System.out.println("test on head: " + head(list).map(p::test));
		return !head(list).isPresent()
			? ImmutableList.of()
			: p.test(head(list).get())
			? prepend(filter(tail(list).get(), p), head(list).get())
			: filter(tail(list).get(), p);
	}

	public static <T> List<T> concat(final List<T>... lists) {
		return reduce(
				(List<List<T>>) ImmutableList.copyOf((List<T>[]) lists),
				(List<T>) ImmutableList.<T>of(),
				ListOps::concatTwo,
				null);
	}

	public static <T, U> U reduce(
			final List<T> list,
			final U identity,
			final BiFunction<U,T,U> accumulator,
			final BinaryOperator<U> combiner) {

		return head(list).isPresent()
			? reduce(
					tail(list).get(),
					accumulator.apply(identity, head(list).get()),
					accumulator,
					combiner)
			: identity;
	}

	private static <T> List<T> concatTwo(
			final List<T> first,
			final List<T> second) {

		return head(first).isPresent()
			? prepend(concatTwo(tail(first).get(), second), head(first).get())
			: second;
	}

	private static <T> List<T> prepend(final List<T> list, final T prefix) {
		return ImmutableList.copyOf(
				Iterables.concat(
						ImmutableList.of(prefix),
						list));
	}

	private static <T> Optional<T> head(final List<T> list) {
		return nonEmpty(list)
			.map(l -> l.get(0));
	}

	private static <T> Optional<List<T>> tail(final List<T> list) {
		return nonEmpty(list)
			.map(l -> l.subList(1, list.size()));
	}

	private static <T> Optional<List<T>> nonEmpty(final List<T> list) {
		return Optional.of(list)
			.filter(l -> !l.isEmpty());
	}
}
