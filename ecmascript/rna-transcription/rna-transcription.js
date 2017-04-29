const replaceNucleotide = nucleotide => {
  switch (nucleotide) {
    case 'G': return 'C';
    case 'C': return 'G';
    case 'T': return 'A';
    case 'A': return 'U';
    default: throw new Error('Invalid input DNA.');
  }
}

export default class Transcriptor {
  toRna(dna) {
    return [...dna].map(replaceNucleotide).join('')
  }
}
