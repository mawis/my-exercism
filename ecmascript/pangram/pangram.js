const chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
	       'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

export default class Pangram {
  constructor(phrase) {
    this.phrase = phrase.toLowerCase()
  }

  isPangram() {
    return chars.every(ch => this.phrase.includes(ch))
  }
}
