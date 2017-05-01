const bottles =
      no => no == 0 ? "no more bottles"
      : no == 1 ? "1 bottle"
      : `${no} bottles`

const capitalBottles =
      no => no == 0 ? "No more bottles"
      : bottles(no)

const takeIt =
      no => no == 0 ? "Go to the store and buy some more"
      : no == 1 ? "Take it down and pass it around"
      : "Take one down and pass it around"

const range = (start, end) => [...Array(end - start + 1).keys()]
      .map(el => el + start)

export default {
  verse(no) {
    return capitalBottles(no) + " of beer on the wall, "
      + bottles(no) + " of beer.\n" + takeIt(no) + ", "
      + bottles((no + 99) % 100) + " of beer on the wall.\n"
  },

  sing(from = 99, to = 0) {
    return range(to, from).reverse().map(no => this.verse(no)).join('\n')
  }
}
