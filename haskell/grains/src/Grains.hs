module Grains (square, total) where

square :: Integer -> Maybe Integer
square n
  | n `elem` [1..64] = Just (2 ^ (n - 1))
  | otherwise = Nothing

total :: Integer
total = 2 ^ 64 - 1
-- On any square we have 2 to the power of the field number (counting from 0)
-- grains. Each of these numbers in binary is a digit 1 followed by the
-- field number of zero digits.
-- If we sum this up we have a '1' in any of the binary digits 2^0 to 2^63.
-- In binary a all one number gets a 1 followed by that many 0s that we had
-- digit 1s before.
-- Therefore the sum of grains is 11111...11111 (64 binary digits 1) which
-- is 2 ^ 64 - 1 (in decimal).
