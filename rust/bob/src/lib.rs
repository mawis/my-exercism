pub fn reply(question: &'static str) -> &'static str {
    let is_lowercase = |char| match char {
                                  'a'...'z' => true,
                                  _         => false };

    if question.is_empty() {
        "Fine. Be that way!"
    } else if !question.chars().any(is_lowercase) {
        "Whoa, chill out!"
    } else if question.ends_with("?") {
        "Sure."
    } else {
        "Whatever."
    }
}
