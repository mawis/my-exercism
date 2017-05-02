import java.io.StringWriter;
import java.util.stream.IntStream;

public class RnaTranscription {
	public String ofDna(final String dnaString) {
		return dnaString.chars()
			.flatMap(RnaTranscription::dna2Rna)
			.collect(
					StringWriter::new,
					StringWriter::write,
					(swl, swr) -> swl.write(swr.toString()))
			.toString();
	}

	private static IntStream dna2Rna(final int character) {
		return character == 'G' ? IntStream.of('C')
			: character == 'C' ? IntStream.of('G')
			: character == 'T' ? IntStream.of('A')
			: character == 'A' ? IntStream.of('U')
			: IntStream.empty();
	}
}
