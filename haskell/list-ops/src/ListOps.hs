module ListOps
  ( length
  , reverse
  , map
  , filter
  , foldr
  , foldl'
  , (++)
  , concat
  ) where

import Prelude hiding
  ( length, reverse, map, filter, foldr, (++), concat )

foldl' :: (b -> a -> b) -> b -> [a] -> b
foldl' _ acc [] = acc
foldl' f acc (x:xs) = acc `seq` foldl' f (f acc x) xs

foldr :: (a -> b -> b) -> b -> [a] -> b
foldr _ z [] = z
foldr f z (x:xs) = f x $ foldr f z xs

length :: [a] -> Int
length = length' 0
  where length' n [] = n
        length' n (_:xs) = length' (n + 1) xs

reverse :: [a] -> [a]
reverse = reverse' []
  where reverse' acc [] = acc
        reverse' acc (x:xs) = reverse' (x:acc) xs

map :: (a -> b) -> [a] -> [b]
map _ [] = []
map f (x:xs) = f x : map f xs

filter :: (a -> Bool) -> [a] -> [a]
filter _ [] = []
filter p (x:xs)
  | p x       = x : filter p xs
  | otherwise = filter p xs

(++) :: [a] -> [a] -> [a]
[] ++ ys = ys
(x:xs) ++ ys = x : (xs ++ ys)

concat :: [[a]] -> [a]
concat [] = []
concat (xs:xss) = xs ++ concat xss
