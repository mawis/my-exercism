use std::char;

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
        .filter(|ch| ch.is_alphanumeric() && ch.is_ascii())
        .flat_map(char::to_lowercase)
        .flat_map(|ch|
                  if ch.is_ascii() && ch.is_alphabetic() {
                      char::from_u32('z' as u32 - (ch as u32 - 'a' as u32))
                  } else {
                      Some(ch)
                  })
}
