extern crate itertools;
use itertools::unfold;

// return Ok(x) where x is the number of steps required to reach 1
pub fn collatz(n: u64) -> Result<u64, &'static str> {
    if n == 0 {
        Err("n must not be zero!")
    } else {
        Ok(unfold(n, next).count() as u64)
    }
}

fn next(n: &mut u64) -> Option<u64> {
    if *n != 1 {
        *n = if *n % 2 == 0 { *n / 2 } else { 3 * *n + 1 };
        Some(*n)
    }
    else { None }
}
