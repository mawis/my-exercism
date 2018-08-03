use std::vec::Vec;

pub fn is_valid(code: &str) -> bool {
    let (count, invalid_char, luhn, _) =
        code.chars()
        .flat_map(decode_digit)
        .fold((0, false, 0, 0), luhn_reducer);

    luhn == 0 && count > 1 && !invalid_char
}

fn luhn_reducer((count, invalid_char, if_even, if_odd): (u32, bool, u32, u32),
                digit_res: Result<u32, char>)
                -> (u32, bool, u32, u32) {

    let digit = digit_res.unwrap_or(0);
    let next_if_even = (if_odd + digit) % 10;
    let next_if_odd =
        (if_even + (2 * digit - if digit >= 5 { 9 } else { 0 })) % 10;
    (count + 1, invalid_char || digit_res.is_err(), next_if_even, next_if_odd)
}

fn decode_digit(ch: char) -> Vec<Result<u32, char>> {
    if ch.is_digit(10) || ch == ' ' {
        ch.to_digit(10).iter().cloned().map(Ok).collect()
    } else {
        vec![Err(ch)]
    }
}
