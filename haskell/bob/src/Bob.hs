module Bob (responseFor) where

import Data.Char

responseFor :: String -> String
responseFor xs
    | all isSpace xs = "Fine. Be that way!"
    | isShout        = "Whoa, chill out!"
    | isQuestion     = "Sure."
    | otherwise      = "Whatever."
  where isShout = (not . any isLower $ xs) && any isUpper xs
        isQuestion = last (filter (not . isSpace) xs) == '?'
