pub fn hamming_distance(a: &str, b: &str) -> Result<usize, &'static str> {
    if a.len() != b.len() {
        Err("Length differs")
    } else {
        Ok(a.chars()
           .zip(b.chars())
           .filter(|&(a_prime, b_prime)| a_prime != b_prime)
           .count())
    }
}
