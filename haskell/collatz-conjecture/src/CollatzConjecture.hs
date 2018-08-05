module CollatzConjecture (collatz) where

import Data.List (genericLength)

collatz :: Integer -> Maybe Integer
collatz n
  | n < 1     = Nothing
  | otherwise = Just . genericLength $ collatzBeforeFirstOne n

collatzBeforeFirstOne :: Integer -> [Integer]
collatzBeforeFirstOne = takeWhile (> 1) . collatzSeq

collatzSeq :: Integer -> [Integer]
collatzSeq n
  | n < 1     = []
  | even n    = n : collatzSeq (n `div` 2)
  | otherwise = n : collatzSeq (3 * n + 1)
