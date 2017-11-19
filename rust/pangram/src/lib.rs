use std::collections::HashSet;

pub fn is_pangram(sentence: &str) -> bool {
    sentence.to_lowercase()
        .chars()
        .filter(|&ch| ch >= 'a' && ch <= 'z')
        .collect::<HashSet<char>>()
        .len() == 26
}
