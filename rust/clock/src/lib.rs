#[derive(Debug, PartialEq)]
pub struct Clock {
    minutes_of_day: u32
}

impl Clock {
    pub fn new(h: i32, m: i32) -> Clock {
        Clock::of_minutes(h * 60 + m)
    }

    pub fn add_minutes(&self, m: i32) -> Clock {
        Clock::of_minutes(self.minutes_of_day as i32 + m)
    }

    pub fn of_minutes(m: i32) -> Clock {
        Clock { minutes_of_day:
                (m % (24 * 60) + if m < 0 { 24 * 60 } else { 0 }) as u32 }
    }

    pub fn to_string(&self) -> String {
        format!("{:02}:{:02}", self.hour(), self.minutes())
    }

    fn hour(&self) -> u32 {
        self.minutes_of_day / 60
    }

    fn minutes(&self) -> u32 {
        self.minutes_of_day % 60
    }
}
