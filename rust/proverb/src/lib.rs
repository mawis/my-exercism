use std::iter::once;

pub fn build_proverb(list: Vec<&str>) -> String {
    match list.clone().first() {
        None => String::new(),
        Some(first) => {
            list.windows(2)
                .map(format_pair)
                .chain(once(format!("And all for the want of a {}.", first)))
                .collect::<Vec<String>>()
                .join("\n")
        }
    }
}

fn format_pair(pair: &[&str]) -> String {
    format!("For want of a {} the {} was lost.", pair[0], pair[1])
}
