use std::char;

const ALPHABETIC_MIRROR_POSITION: u32 = 'z' as u32 + 'a' as u32;

pub fn encode(plain: &str) -> String {
    atbash_transpose(plain)
        .enumerate()
        .flat_map(|(pos, ch)|
                  if pos > 0 && pos % 5 == 0 { vec![' ', ch] }
                  else { vec![ch] })
        .collect()
}

pub fn decode(cipher: &str) -> String {
    atbash_transpose(cipher)
        .collect()
}

fn atbash_transpose<'a>(text: &'a str) -> impl Iterator<Item = char> + 'a {
    text.chars()
        .filter(codeable_character)
        .flat_map(char::to_lowercase)
        .map(transpose_alphabetics)
}

fn codeable_character(ch: &char) -> bool {
    ch.is_alphanumeric() && ch.is_ascii()
}

fn transpose_alphabetics(ch: char) -> char {
    if ch.is_ascii() && ch.is_alphabetic() {
        char::from_u32(ALPHABETIC_MIRROR_POSITION - (ch as u32)).unwrap()
    } else {
        ch
    }
}
