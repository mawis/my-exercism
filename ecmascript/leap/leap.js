export default function isLeapYear(year) {
  const divisibleBy = (divident) => year % divident === 0;

  return divisibleBy(400) || divisibleBy(4) && !divisibleBy(100)
}
