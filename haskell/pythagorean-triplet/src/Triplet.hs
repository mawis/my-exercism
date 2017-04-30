module Triplet (isPythagorean, mkTriplet, pythagoreanTriplets) where

import Data.List (sort)

isPythagorean :: (Int, Int, Int) -> Bool
isPythagorean (a, b, c) = pythoTest $ sort [a, b, c]
  where pythoTest [a', b', c'] = a' * a' + b' * b' == c' * c'
        pythoTest _ = error "The list should have exactly 3 elements"

mkTriplet :: Int -> Int -> Int -> (Int, Int, Int)
mkTriplet a b c = (a, b, c)

pythagoreanTriplets :: Int -> Int -> [(Int, Int, Int)]
pythagoreanTriplets minf maxf = filter isPythagorean candidates
  where candidates = do
          a <- [minf..maxf - 2]
          b <- [a + 1..maxf - 1]
          c <- [b + 1..maxf]
          return (a, b, c)
