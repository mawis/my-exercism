const NAMES: [&str; 7] = ["",
                          "thousand",
                          "million",
                          "billion",
                          "trillion",
                          "quadrillion",
                          "quintillion"];

pub fn encode(num: u64) -> String {
    if num == 0 { String::from("zero") }
    else { encode_number(num) }
}

fn encode_number(num: u64) -> String {
    (0..7)
        .map(|group| (NAMES[group], (num / 1000u64.pow(group as u32)) % 1000))
        .filter(|&(_, val)| val != 0)
        .map(|(name, val)|
             if String::new() == *name { digit_triple(val) }
             else { format!("{} {}", digit_triple(val), name)})
        .rev()
        .collect::<Vec<String>>()
        .join(" ")
}

fn digit_triple(g: u64) -> String {
    if g < 100 { digit_pair(g) }
    else if g % 100 == 0 { format!("{} hundred", unit(g / 100)) }
    else { format!("{} hundred {}", unit(g / 100), digit_pair(g % 100)) }
}

fn digit_pair(g: u64) -> String {
    match g {
        _ if g < 10 => unit(g),
        10 => String::from("ten"),
        11 => String::from("eleven"),
        12 => String::from("twelve"),
        13 => String::from("thirteen"),
        14 => String::from("fourteen"),
        15 => String::from("fifteen"),
        _ if g < 20 => unit(g - 10)+"teen",
        _ if g < 30 => regular_tenner("twenty", g % 10),
        _ if g < 40 => regular_tenner("thirty", g % 10),
        _ if g < 50 => regular_tenner("forty", g % 10),
        _ if g < 60 => regular_tenner("fifty", g % 10),
        _ if g < 70 => regular_tenner("sixty", g % 10),
        _ if g < 80 => regular_tenner("seventy", g % 10),
        _ if g < 90 => regular_tenner("eighty", g % 10),
        _ if g < 100 => regular_tenner("ninety", g % 10),
        _ => String::new()
    }
}

fn regular_tenner(t: &str, u: u64) -> String {
    if u == 0 { String::from(t) }
    else { format!("{}-{}", t, unit(u)) }
}

fn unit(digit: u64) -> String {
    match digit {
        1 => String::from("one"),
        2 => String::from("two"),
        3 => String::from("three"),
        4 => String::from("four"),
        5 => String::from("five"),
        6 => String::from("six"),
        7 => String::from("seven"),
        8 => String::from("eight"),
        9 => String::from("nine"),
        _ => String::new()
    }
}
