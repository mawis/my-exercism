#[derive(Debug, PartialEq, Eq)]
pub enum Classification {
    Abundant,
    Perfect,
    Deficient
}

pub fn classify(num: u64) -> Result<Classification, & 'static str> {
    match aliquot_sum(num) {
        _ if num == 0 => Err("Number must be positive"),
        n if n > num => Ok(Classification::Abundant),
        n if n == num => Ok(Classification::Perfect),
        _ => Ok(Classification::Deficient)
    }
}

fn aliquot_sum(num: u64) -> u64 {
    (1..(num / 2 + 1))
        .filter(|n| num % n == 0)
        .sum()
}
