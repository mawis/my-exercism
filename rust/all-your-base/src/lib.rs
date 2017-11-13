pub fn convert(number: &[u32], from_base: u32, to_base: u32) 
               -> Result<Vec<u32>, &'static str> {
    if from_base < 2 || to_base < 2 {
        Err("Invalid base.")
    } else if
        number.iter().filter(|&&digit| digit >= from_base).nth(0) .is_some() {
        Err("Invalid digit.")
    } else {
        Ok(encode(decode(number, from_base), to_base))
    }
}

fn decode(number: &[u32], base: u32) -> u32 {
    number.iter()
        .fold(0, |accu, digit| accu * base + digit)
}

fn encode(mut number: u32, base: u32) -> Vec<u32> {
    let mut accu = Vec::new();
    while number > 0 {
        accu.push(number % base);
        number /= base;
    }
    accu.reverse();
    accu
}
