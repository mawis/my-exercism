module Raindrops (convert) where

factors :: [(Int, String)]
factors = [(3, "Pling"), (5, "Plang"), (7, "Plong")]

convert :: Int -> String
convert n
  | null names = show n
  | otherwise  = names
  where names = factors >>= factorName
        factorName (f, name) = if n `mod` f == 0 then name else ""
