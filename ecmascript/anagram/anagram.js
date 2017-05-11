const equalArrays = function (a1, a2) {
  return a1.length === a2.length && a1.every((el, idx) => el === a2[idx])
}

const isAnagram = function([...candidate], [...word]) {
  return !equalArrays(candidate, word)
	&& equalArrays(candidate.sort(), word.sort())
}

export default class Anagram {
  constructor(word) {
	this.word = word.toLowerCase()
  }

  matches(...argument) {
	const candidates = Array.isArray(argument[0]) ? argument[0] : argument;
	return candidates
	  .filter(candidate => isAnagram(candidate.toLowerCase(), this.word));
  }
}
