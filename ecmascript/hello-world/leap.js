function isLeapYear(year) {
  function yearDivisibleBy(divisor) {
    return year % divisor === 0
  }

  return yearDivisibleBy(400) || yearDivisibleBy(4) && !yearDivisibleBy(100)
}
