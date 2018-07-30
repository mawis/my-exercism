pub fn series(digits: &str, len: usize) -> Vec<String> {
    if len > digits.len() {
        Vec::new()
    } else {
        (0..=(digits.len() - len))
            .map(|start|
                 (*(&digits[start..(start + len)].to_string())).clone())
            .collect()
    }
}
