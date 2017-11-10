use std::cmp::max;
use std::iter::Iterator;

fn group_by_character(acc: Vec<(char, usize)>, ch: char) -> Vec<(char, usize)> {
    match acc.last() {
        None => vec![(ch, 1)],
        Some(&(last_ch, last_size)) => {
            let mut new_acc = acc.clone();
            if last_ch == ch {
                new_acc.pop();
                new_acc.push((ch, last_size + 1));
            } else {
                new_acc.push((ch, 1))
            }
            new_acc
        }
    }
}

fn encode_group((ch, s): (char, usize)) -> String {
    if s == 1 {
        ch.to_string()
    } else {
        format!("{}{}", s, ch)
    }
}

pub fn encode(text: &str) -> String {
    text.chars()
        .fold(vec![], group_by_character)
        .into_iter()
        .map(encode_group)
        .collect::<Vec<String>>()
        .join("")
}

fn decode_char(acc: (usize, String), ch: char) -> (usize, String) {
    match ch.to_digit(10) {
        Some(val) => (acc.0 * 10 + (val as usize), acc.1),
        None => (0, format!("{}{}",
                            acc.1,
                            ch.to_string().repeat(max(1, acc.0)).to_string()))
    }
}

pub fn decode(text: &str) -> String {
    text.chars()
        .fold((0, String::new()), decode_char)
        .1
}
