pub fn is_leap_year(year: i64) -> bool {
    let divisible_by = |interval: i64| year % interval == 0;

    divisible_by(400) || divisible_by(4) && !divisible_by(100)
}