use std::cmp;
use std::u64;

pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    matrix_indices(input)
        .filter(|(row, col)| test_saddle_point(input, *row, *col))
        .collect()
}

fn matrix_indices<'a>(input: &'a [Vec<u64>])
                      -> impl Iterator<Item=(usize,usize)> + 'a {
    (0..input.len()).flat_map(move |row|
                              (0..input[row].len()).map(move |col| (row, col)))
}

fn test_saddle_point(input: &[Vec<u64>], row: usize, col: usize) -> bool {
    let max_in_row = input[row].iter().cloned().fold(0, cmp::max);
    let min_in_col = input.iter().map(|r| r[col]).fold(u64::MAX, cmp::min);

    max_in_row == min_in_col && input[row][col] == max_in_row
}
