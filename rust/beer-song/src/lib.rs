fn bottles(n: u8) -> String {
    match n {
        0 => "no more bottles of beer".to_string(),
        1 => "1 bottle of beer".to_string(),
        _ => format!("{} bottles of beer", n)
    }
}

fn upper_bottles(n: u8) -> String {
    match n {
        0 => "No more bottles of beer".to_string(),
        _ => bottles(n)
    }
}

fn action(v: u8) -> String {
    match v {
        0 => "Go to the store and buy some more".to_string(),
        1 => "Take it down and pass it around".to_string(),
        _ => "Take one down and pass it around".to_string()
    }
}

pub fn verse(v: u8) -> String {
    format!("{} on the wall, {}.\n{}, {} on the wall.\n", 
            upper_bottles(v), bottles(v), action(v), bottles((v + 99) %100))
}

pub fn sing(first: u8, last: u8) -> String {
    (last..(first + 1)).rev()
        .map(verse)
        .collect::<Vec<_>>()
        .join("\n")
}
