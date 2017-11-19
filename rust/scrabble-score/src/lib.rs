static LETTER_SCORES: [&str; 10] =
    ["aeioulnrst", "dg", "bcmp", "fhvwy", "k", "", "", "jx", "", "qz"];

pub fn score(word: &str) -> usize {
    word.to_lowercase().chars()
        .map(|ch| char_value(ch))
        .sum()
}

fn char_value(ch: char) -> usize {
    LETTER_SCORES.iter()
        .zip(1..11)
        .filter_map(|(chrs, s)| if chrs.contains(ch) { Some(s) } else { None })
        .nth(0)
        .unwrap_or(0)
}
