export default class Pangram {
  constructor(phrase) {
    this.phrase = phrase.toLowerCase()
  }

  isPangram() {
    return [..."abcdefghijklmnopqrstuvwxyz"]
      .every(ch => this.phrase.includes(ch))
  }
}
