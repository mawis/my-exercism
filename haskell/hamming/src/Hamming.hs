module Hamming (distance) where

distance :: String -> String -> Maybe Int
distance [] [] = Just 0
distance (x:xs) (y:ya) = fmap (+ (fromEnum $ x /= y)) $ distance xs ya
distance _ _ = Nothing
