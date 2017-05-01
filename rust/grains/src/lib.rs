pub fn square(s: u32) -> u64 {
    assert!(s >= 1 && s <= 64, "Square must be between 1 and 64");
    1u64 << (s - 1)
}

pub fn total() -> u64 {
    (1..65).map(square).sum()
}
