#[derive(Debug)]
pub struct Clock {
    minutes_of_day: u32
}

impl Clock {
    pub fn new(h: i32, m: i32) -> Clock {
        Clock { minutes_of_day: normalize(h * 60 + m) }
    }

    pub fn add_minutes(&self, m: i32) -> Clock {
        Clock { minutes_of_day: normalize(self.minutes_of_day as i32 + m) }
    }

    pub fn to_string(&self) -> String {
        format!("{:02}:{:02}", self.hour(), self.minutes())
    }

    fn hour(&self) -> u32 {
        self.minutes_of_day / 60 % 24
    }

    fn minutes(&self) -> u32 {
        self.minutes_of_day % 60
    }
}

impl PartialEq for Clock {
    fn eq(&self, other: &Clock) -> bool {
        self.minutes_of_day == other.minutes_of_day
    }
}

fn normalize(minute: i32) -> u32 {
    (minute % (24 * 60) + if minute < 0 { 24 * 60 } else { 0 }) as u32
}
