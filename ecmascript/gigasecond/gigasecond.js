export default class Gigasecond {
  constructor (base) {
    this.base = base
  }

  date() {
      return new Date(this.base.getTime() + 1e12)
  }
}
