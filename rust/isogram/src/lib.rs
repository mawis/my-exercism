use std::collections::HashMap;

pub fn check(word: &str) -> bool {
    word.to_string()
        .to_lowercase()
        .chars()
        .filter(|ch| ch.is_alphabetic())
        .fold(HashMap::new(),
              |mut m, ch| { *(m.entry(ch).or_insert(0)) += 1; m })
        .values()
        .filter(|cnt| **cnt > 1)
        .nth(0)
        .is_none()
}
