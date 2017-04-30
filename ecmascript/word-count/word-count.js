const addWords = (accu, word) => {
  accu[word]++ || (accu[word] = 1);
  return accu
}

export default class Words {
  count(text) {
    return text.trim()
      .split(/\s+/)
      .map(s => s.toLowerCase())
      .reduce(addWords, {})
  }
}
