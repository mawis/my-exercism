const isUpper = ch => ch.toUpperCase() === ch && ch.toLowerCase() !== ch
const isLower = ch => ch.toLowerCase() === ch && ch.toUpperCase() !== ch
const isShout = message =>
      [...message].some(isUpper) && ![...message].some(isLower);
const isQuestion = message => message.match(/\?$/);
const isSilence = message => message.trim() === "";

export default class Bob {
  hey(message) {
    return isSilence(message) ? 'Fine. Be that way!'
      : isShout(message) ? 'Whoa, chill out!'
      : isQuestion(message) ? 'Sure.'
      : 'Whatever.'
  }
}
