extern crate regex;

use regex::Regex;

pub fn is_valid_isbn(isbn: &str) -> bool {
    let cleaned_isbn: String = isbn.chars()
        .filter(|ch| ch.is_alphanumeric())
        .collect();

    valid_syntax(&cleaned_isbn) && valid_checksum(&cleaned_isbn)
}

fn valid_syntax(isbn: &String) -> bool {
    Regex::new(r"^[0-9]{9}[0-9Xx]$").unwrap().is_match(isbn)
}

fn valid_checksum(isbn: &String) -> bool {
    let values = (*isbn).chars()
        .map(|ch| digit_value(ch))
        .collect::<Vec<u32>>();
    (0..10)
        .map(|n| values[n] as u64 * (10 - n as u64))
        .sum::<u64>() % 11 == 0
}

fn digit_value(ch: char) -> u32 {
    ch.to_digit(10).unwrap_or(10)
}
