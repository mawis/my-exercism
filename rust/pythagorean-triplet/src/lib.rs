pub fn find() -> Option<u32> {
    // building a stream of primitive pythagorean triples …
    (2..1000).flat_map(|u| (1..u).map(move |v| (u, v)))
        .filter(|&(u, v)| gcd(u, v) == 1 && (u % 2 == 0 || v % 2 == 0))
        .map(|(u, v)| (u * u - v * v, 2 * u * v, u * u + v * v))
        // multiplined with natural numbers they are still pythagorean
        .filter(|&(a, b, c)| 1000 % (a + b + c) == 0)
        .map(|(a, b, c)| {
            let n = 1000 / (a + b + c);
            (a * n, b * n, c * n)
        })
        // everything here has a sum of 1000, build the product:
        .map(|(a, b, c)| (a * b * c) as u32)
        .nth(0)
}

fn gcd(a: usize, b: usize) -> usize {
    let mut x = a;
    let mut y = b;
    while y != 0 {
        let t = y;
        y = x % y;
        x = t;
    }
    x
}
