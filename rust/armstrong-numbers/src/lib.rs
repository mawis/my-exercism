pub fn is_armstrong_number(num: u32) -> bool {
    let digit_count = Digits::of(num).count();
    let sum = Digits::of(num).map(|n| n.pow(digit_count as u32))
        .fold(0, |accu, n| accu + n);
    num == sum
}

struct Digits {
    remaining_digits: u32
}

impl Digits {
    pub fn of(n: u32) -> Digits {
        Digits {
            remaining_digits: n
        }
    }
}

impl Iterator for Digits {
    type Item = u32;

    fn next (&mut self) -> Option<Self::Item> {
        if self.remaining_digits == 0 {
            None
        } else {
            let next_val = self.remaining_digits % 10;
            self.remaining_digits /= 10;
            Some(next_val)
        }
    }
}
