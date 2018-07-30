module PerfectNumbers (classify, Classification(..)) where

data Classification = Deficient | Perfect | Abundant deriving (Eq, Show)

classify :: Int -> Maybe Classification
classify n = classify' <$> aliquotSum n
  where classify' m
          | m < n     = Deficient
          | m > n     = Abundant
          | otherwise = Perfect

aliquotSum :: Int -> Maybe Int
aliquotSum n
  | n <= 0    = Nothing
  | otherwise = Just (sum (filter is_dividor [1 .. n - 1]))
    where is_dividor i = n `mod` i == 0
