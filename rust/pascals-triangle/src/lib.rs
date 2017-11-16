use std::iter::once;

pub struct PascalsTriangle {
    row_count: u32
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        PascalsTriangle{ row_count: row_count }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        let zero = 0;
        (0..self.row_count)
            .fold(Vec::new() as Vec<Vec<u32>>,
                  |mut accu, _| {
                      let new_row = match accu.last() {
                      None => vec![1u32],
                      Some(last) => {
                          (*last).iter().chain(once(&zero))
                              .zip(once(&zero).chain(last.iter()))
                              .map(|(a, b)| a + b)
                              .collect() }};
                      accu.push(new_row);
                      accu })
    }
}
