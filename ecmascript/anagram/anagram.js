const equalArrays = (a1, a2) =>
	  a1.length === a2.length
	  && a1.every((el, idx) => el === a2[idx])

const isAnagram = ([...candidate], [...word]) =>
  !equalArrays(candidate, word)
	&& equalArrays(candidate.sort(), word.sort())

const flatten = array => Array.prototype.concat(...array)

export default class Anagram {
  constructor(word) {
	this.word = word.toLowerCase()
  }

  matches(...candidates) {
	return flatten(candidates)
	  .filter(candidate => isAnagram(candidate.toLowerCase(), this.word));
  }
}
