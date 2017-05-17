import java.util.stream.IntStream;

public class LuhnValidator {
	private static final int INVALID_DIGIT = -1;
	public boolean isValid(final String numberString) {
		return numberString.chars()
			.flatMap(LuhnValidator::decodeDigit)
			.boxed()
			.reduce(Accu.IDENTITY, Accu::add, Accu::combine)
			.isValidResult();
	}

	private static IntStream decodeDigit(int ch) {
		return '0' <= ch && ch <= '9' ? IntStream.of(ch - '0')
			: ch == ' ' ? IntStream.empty()
			: IntStream.of(INVALID_DIGIT);
	}

	@lombok.Value
	private static class Accu {
		private static final Accu IDENTITY = new Accu(0, 0, 0, false);

		private final int ifEven;
		private final int ifOdd;
		private final int count;
		private final boolean failed;

		public boolean isValidResult() {
			return count > 1 && !failed && ifEven == 0;
		}

		public Accu add(final Integer digit) {
			return failed ? this
				: digit == INVALID_DIGIT ? new Accu(0, 0, 0, true)
				: new Accu(
						(ifOdd + digit) % 10,
						(ifEven + digit * 2 - (digit >= 5 ? 9 : 0)) % 10,
						count + 1,
						false);
		}

		public Accu combine(final Accu other) {
			// digits depend on position, we can't run on a parallel stream
			throw new UnsupportedOperationException("parallel not supported");
		}
	}
}
