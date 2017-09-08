const animals = [
  ['fly',    '', ''],
  ['spider', 'It wriggled and jiggled and tickled inside her.',
   ' that wriggled and jiggled and tickled inside her'],
  ['bird',   'How absurd to swallow a bird!', ''],
  ['cat',    'Imagine that, to swallow a cat!', ''],
  ['dog',    'What a hog, to swallow a dog!', ''],
  ['goat',   'Just opened her throat and swallowed a goat!', ''],
  ['cow',    "I don't know how she swallowed a cow!", '']]

const range = (start, end) => [...Array(end - start + 1).keys()]
	  .map(el => el + start)
const asLine = line => line === '' ? line : line + '\n'
const thing = verse => animals[verse][0]
const reaction = verse => asLine(animals[verse][1])
const extra = verse => animals[verse][2]
const lineOne = verse =>
	  'I know an old lady who swallowed a ' + thing(verse) + '.\n'
const lastLine = "I don't know why she swallowed the fly. Perhaps she'll die.\n"
const intermediate = line => 'She swallowed the ' + thing(line)
	  + ' to catch the ' + thing(line - 1)
	  + extra(line - 1) + '.\n'
const intermediates =
	  verse => range(1, verse).reverse().map(intermediate).join('')

export default class Song {
  verse(counted_from_one) {
	const verse = counted_from_one - 1;
	return verse == 7
	? "I know an old lady who swallowed a horse.\nShe's dead, of course!\n"
	: lineOne(verse) + reaction(verse) + intermediates(verse) + lastLine
  }

  verses(first, last) {
	return range(first, last).map(this.verse).join('\n') + '\n'
  }
}
