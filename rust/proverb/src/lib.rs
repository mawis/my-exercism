use std::iter::once;

pub fn build_proverb(list: Vec<&str>) -> String {
    match list.clone().first() {
        None => String::new(),
        Some(first) => {
            interleaved_pairs(list)
                .into_iter()
                .map(format_pair)
                .chain(once(format!("And all for the want of a {}.", first)))
                .collect::<Vec<String>>()
                .join("\n")
        }
    }
}

fn interleaved_pairs(list: Vec<&str>) -> Vec<(&str, &str)> {
    list.into_iter()
        .fold((None, Vec::new()),
              |(last, mut accu), next|
              {
                  match last {
                      Some(name) => accu.push((name, next)),
                      None => ()
                  }
                  (Some(next), accu)
              }
        ).1
}

fn format_pair((first, second): (&str, &str)) -> String {
    format!("For want of a {} the {} was lost.", first, second)
}
