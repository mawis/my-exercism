module Grains (square, total) where

import Control.Monad (sequence)

square :: Integer -> Maybe Integer
square n
  | n `elem` [1..64] = Just (2 ^ (n - 1))
  | otherwise = Nothing

total :: Integer
total = case total' of Just s -> s
                       _      -> error "Really Nothing?"
  where total' = fmap sum . sequence $ map square [1..64]
