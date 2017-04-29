const zip = (a1, a2) => a1.map((el, idx) => [el, a2[idx]]);
const isDifferent = ([a1, a2]) => a1 !== a2;

export default class Hamming {
  compute(a1, a2) {
    if (a1.length !== a2.length) {
      throw new Error('DNA strands must be of equal length.')
    }

    return zip([...a1],
	       [...a2])
      .filter(isDifferent)
      .length
  }
}
