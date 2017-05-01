pub fn square_of_sum(limit: u32) -> u32 {
    (1..limit + 1).fold(0, |accu, s| accu + s).pow(2)
}

pub fn sum_of_squares(limit: u32) -> u32 {
    (1..limit + 1).map(|n| n * n).fold(0, |accu, s| accu + s)
}

pub fn difference(limit: u32) -> u32 {
    square_of_sum(limit) - sum_of_squares(limit)
}
