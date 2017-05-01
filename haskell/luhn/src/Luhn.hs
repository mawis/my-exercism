module Luhn (addends, checkDigit, checksum, create, isValid) where

addends :: Integer -> [Integer]
addends = reverse . helper True
  where helper isOdd n
          | n <= 0    = []
          | isOdd     = digit:helper False rest
          | digit < 5 = (digit * 2):helper True rest
          | otherwise = (digit * 2 - 9):helper True rest
          where digit = n `mod` 10
                rest  = n `div` 10

checkDigit :: Integer -> Integer
checkDigit = (`mod` 10)

checksum :: Integer -> Integer
checksum = foldr addMod 0 . addends
  where addMod a b = (a + b) `mod` 10

create :: Integer -> Integer
create n = n * 10 + makeCheckDigit
  where makeCheckDigit = (10 - checksum (n * 10)) `mod` 10

isValid :: Integer -> Bool
isValid n = checksum n == 0
