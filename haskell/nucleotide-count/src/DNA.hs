module DNA (nucleotideCounts) where

import Data.Map (Map, adjust, fromList)

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts "" = Right
                      $ fromList [ ('A', 0), ('C', 0), ('G', 0), ('T', 0) ]
nucleotideCounts (x:xs)
    | x `elem` "ACGT" = oneMore x <$> nucleotideCounts xs
    | otherwise       = Left "Invalid nucleotide"
  where oneMore = adjust (+1)
