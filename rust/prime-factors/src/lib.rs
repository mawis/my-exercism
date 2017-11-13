pub fn factors(n: usize) -> Vec<usize> {
    let mut accu = Vec::new();
    let mut remaining = n;
    let mut factor = 2;

    while remaining > 1 {
        if remaining % factor == 0 {
            accu.push(factor);
            remaining /= factor
        } else {
            factor = if factor == 2 { 3 } else { factor + 2 }
        }
    }

    accu
}
