module WordCount (wordCount) where

import Data.Char (toLower)
import Data.Map (fromListWith, toList)

wordCount :: String -> [(String, Integer)]
wordCount = frequencies . map unquote . words . clean . map toLower
  where clean [] = []
        clean (x:xs)
          | x `elem` ('\'':['a'..'z']++['0'..'9']) = x:clean xs
          | otherwise                 = ' ':clean xs
        unquote ('\'':xs) = removeEndQuote xs
          where removeEndQuote [] = []
                removeEndQuote ['\''] = []
                removeEndQuote (x':xs') = x':removeEndQuote xs'
        unquote xs        = xs
        frequencies = toList . fromListWith (+) . map (\x -> (x, 1))
