function aliquot(n) {
  var accu = 0;
  for (var i = 1; i < n; i++) {
    if (n % i === 0) {
      accu += i
    }
  }
  return accu
}

export default class PerfectNumbers {
  classify(num) {
    if (num <= 0) {
      return 'Classification is only possible for natural numbers.'
    }
    const a = aliquot(num);
    return num === a ? 'perfect' : num < a ? 'abundant' : 'deficient'
  }
}
