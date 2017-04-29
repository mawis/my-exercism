pub fn raindrops(num: i32) -> String {
    let divisible_by = |div: i32| num % div == 0;
    let keyword = |div: i32, word: &'static str|
                  if divisible_by(div) { word } else { "" };

    let ppp = [ keyword(3, "Pling"),
                keyword(5, "Plang"),
                keyword(7, "Plong") ].join("");

    if ppp.is_empty() { num.to_string() } else { ppp }
}