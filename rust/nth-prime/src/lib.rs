pub fn nth(n: u32) -> Result<u32, &'static str> {
    if n < 1 { Err("Not a valid n!") }
    else {
        let primes = sieve(estimate_prime(n));
        Ok(primes[(n - 1) as usize])
    }
}

fn estimate_prime(n: u32) -> u32 {
    if n < 6 { 13 }
    else {
        let log_n = (n as f64).ln();
        let log_log_n = log_n.ln();
        2 + n * (log_n + log_log_n) as u32
    }
}

fn sieve(max: u32) -> Vec<u32> {
    let mut candidates = vec!(true; max as usize);
    let sqrt_max = (max as f64).sqrt() as u32;
    for candidate in 2..(sqrt_max + 1) {
        if candidates[candidate as usize] {
            for multiple in 2..((max - 1)/candidate + 1) {
                candidates[(multiple * candidate) as usize] = false;
            }
        }
    }

    (2..max).filter(|num| {
        let idx: usize = num.clone() as usize;
        candidates[idx]
    }) .collect()
}
