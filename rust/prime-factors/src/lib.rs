pub fn factors(n: usize) -> Vec<usize> {
    let (rest, mut factors) =
        (2..((n as f64).sqrt() as usize + 1))
        .fold((n, Vec::new()),
              |(remaining, mut accu), factor| {
                  let (count, prod) = factor_count(remaining, factor);
                  for _ in 0..count {
                      accu.push(factor)
                  }
                  (remaining / prod, accu)
              });
    if rest > 1 {
        factors.push(rest);
    }
    factors
}

fn factor_count(number: usize, factor: usize) -> (usize, usize) {
    let mut count = 0;
    let mut accu = number;
    let mut prod = 1;

    while accu % factor == 0 {
        count += 1;
        accu /= factor;
        prod *= factor;
    }

    (count, prod)
}
