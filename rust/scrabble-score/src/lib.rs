static LETTER_SCORES: [&str; 10] =
    ["aeioulnrst", "dg", "bcmp", "fhvwy", "k", "", "", "jx", "", "qz"];

pub fn score(word: &str) -> usize {
    word.to_lowercase()
        .chars()
        .map(|ch| char_value(ch))
        .sum()
}

fn char_value(ch: char) -> usize {
    LETTER_SCORES.iter()
        .zip(1..11)
        .filter_map(|(chrs, score)|
                    chrs.chars().filter(|&chr| chr == ch).nth(0).map(|_| score))
        .nth(0)
        .unwrap_or(0)
}
