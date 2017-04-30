const addWords = (accu, word) => {
  accu[word] = accu.hasOwnProperty(word) ? accu[word] + 1 : 1;
  return accu
}

export default class Words {
  count(text) {
    return text.trim()
      .split(/[ \n\t]+/)
      .map(s => s.toLowerCase())
      .reduce(addWords, {})
  }
}
