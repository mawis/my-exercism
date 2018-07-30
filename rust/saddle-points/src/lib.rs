use std::cmp;
use std::u64;

pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    matrix_indices(input)
        .iter()
        .cloned()
        .filter(|(row, col)| test_saddle_point(input, *row, *col))
        .collect()
}

fn matrix_indices(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    (0..input.len())
        .flat_map(|row|
                  (0..input[row].len())
                  .map(move |col| (row, col)))
        .collect()
}

fn test_saddle_point(input: &[Vec<u64>], row: usize, col: usize) -> bool {
    let r = input[row].iter();
    let max_in_row = r.fold(0, |a, &b| if a > b { a } else { b });
    let c = input.iter().map(|r| r[col]);
    let min_in_col = c.fold(u64::MAX, cmp::min);

    max_in_row == min_in_col && input[row][col] == max_in_row
}
