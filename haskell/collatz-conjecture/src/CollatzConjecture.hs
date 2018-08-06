module CollatzConjecture (collatz) where

import Data.List (genericLength)

collatz :: Integer -> Maybe Integer
collatz n
  | n < 1     = Nothing
  | otherwise = Just
                . genericLength
                . takeWhile (> 1)
                $ iterate collatzStep n

collatzStep :: Integer -> Integer
collatzStep n
  | even n    = n `div` 2
  | otherwise = 3 * n + 1
