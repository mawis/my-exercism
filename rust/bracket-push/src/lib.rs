extern crate rpds;

use rpds::Stack;

pub struct Brackets {
    balanced: bool
}

impl<'a> From<&'a str> for Brackets {
    fn from(input: &str) -> Self {
        Brackets {
            balanced: Brackets::check_balance(input)
        }
    }
}

impl Brackets {
    pub fn are_balanced(&self) -> bool {
        self.balanced
    }

    fn check_balance(input: &str) -> bool {
        let (remaining_brackets, failed) = input.chars()
            .fold((Stack::new(), false), Brackets::bracket_checker);
        remaining_brackets.peek().is_none() && !failed
    }

    fn bracket_checker((bracket_stack, failed): (Stack<char>, bool), ch: char)
                       -> (Stack<char>, bool) {
        if failed {
            (bracket_stack, failed)
        } else if Brackets::is_opening(ch) {
            (bracket_stack.push(ch), failed)
        } else if Brackets::is_closing(ch) {
            if let Some(last) = bracket_stack.clone().peek() {
                if Brackets::matching(*last, ch) {
                    // matching opening bracket found
                    (bracket_stack.pop().unwrap(), failed)
                } else {
                    // last opening bracket doesn't match
                    (bracket_stack, true)
                }
            } else {
                // nothing on bracket stack
                (bracket_stack, true)
            }
        } else {
            // not a bracket character, just ignore it ...
            (bracket_stack, failed)
        }
    }

    fn is_opening(ch: char) -> bool {
        "({[".find(ch).is_some()
    }

    fn is_closing(ch: char) -> bool {
        "]})".find(ch).is_some()
    }

    fn matching(opening: char, closing: char) -> bool {
        opening == '(' && closing == ')'
            || opening == '[' && closing == ']'
            || opening == '{' && closing == '}'
    }
}
