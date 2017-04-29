fn is_anagram(w1: &str, w2: &str) -> bool {
    let mut s1: Vec<_> = w1.to_string().to_lowercase().chars().collect();
    let mut s2: Vec<_> = w2.to_string().to_lowercase().chars().collect();

    if s1 == s2 {
        false
    } else {
        s1.sort();
        s2.sort();
        s1 == s2
    }
}

pub fn anagrams_for<'a, 'b>(word: &'a str, candidates: &'b[&'b str])
                            -> Vec<&'b str> {

    candidates.iter()
        .cloned()
        .filter(|candidate| is_anagram(word, candidate))
        .collect::<Vec<_>>()
}
