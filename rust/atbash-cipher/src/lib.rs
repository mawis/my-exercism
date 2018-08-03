use std::char;

/// "Encipher" with the Atbash cipher.
pub fn encode(plain: &str) -> String {
    plain.chars()
        .filter(|ch| ch.is_alphanumeric() && ch.is_ascii())
        .flat_map(char::to_lowercase)
        .flat_map(|ch|
                  if ch.is_ascii() && ch.is_alphabetic() {
                      char::from_u32('z' as u32 - (ch as u32 - 'a' as u32))
                  } else {
                      Some(ch)
                  })
        .enumerate()
        .flat_map(|(pos, ch)|
                  if pos > 0 && pos % 5 == 0 { vec![' ', ch] }
                  else { vec![ch] })
        .collect()
}

/// "Decipher" with the Atbash cipher.
pub fn decode(cipher: &str) -> String {
    encode(cipher).chars()
        .filter(|ch| ch.is_alphanumeric())
        .collect()
}
