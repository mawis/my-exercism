module SumOfMultiples (sumOfMultiples) where

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ filter (isMultiple factors) [1.. limit - 1]

isMultiple :: [Integer] -> Integer -> Bool
isMultiple fs n = any  (multipleOf n) fs

multipleOf :: Integer -> Integer -> Bool
multipleOf n f = n `mod` f == 0
