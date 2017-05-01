pub fn sum_of_multiples(limit: u32, factors: &Vec<u32>) -> u32 {
    let is_multiple = |n: &u32| factors.iter().any(|f: &u32| n % f == 0);

    (0..limit).filter(is_multiple).sum()
}
