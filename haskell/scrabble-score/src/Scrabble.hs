module Scrabble (scoreLetter, scoreWord) where

import Data.Char (toUpper)

scores :: [(Integer, String)]
scores = [(1, "AEIOULNRST"),
           (2, "DG"),
           (3, "BCMP"),
           (4, "FHVWY"),
           (5, "K"),
           (8, "JX"),
           (10, "QZ")]

scoreLetter :: Char -> Integer
scoreLetter letter = head ((scores >>= checkMatch (toUpper letter)) ++ [0])
  where checkMatch ltr (pnt, ltrs) = [pnt | ltr `elem` ltrs]

scoreWord :: String -> Integer
scoreWord = sum . map scoreLetter
