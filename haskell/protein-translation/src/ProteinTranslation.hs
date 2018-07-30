module ProteinTranslation(proteins) where

import qualified Data.Map as M
import Data.Map ((!?), fromList)
import Data.Maybe (fromJust, isJust)

proteins :: String -> Maybe [String]
proteins =
  Just . map fromJust . takeWhile isJust . map (proteinNames !?) . group 3

group :: Int -> String -> [String]
group _ [] = []
group n l
  | n > 0 = take n l : group n (drop n l)
  | otherwise = error "negative n"

proteinNames :: M.Map String String
proteinNames = fromList [ ("AUG", "Methionine"),
                          ("UUU", "Phenylalanine"),
                          ("UUC", "Phenylalanine"),
                          ("UUA", "Leucine"),
                          ("UUG", "Leucine"),
                          ("UCU", "Serine"),
                          ("UCC", "Serine"),
                          ("UCA", "Serine"),
                          ("UCG", "Serine"),
                          ("UAU", "Tyrosine"),
                          ("UAC", "Tyrosine"),
                          ("UGU", "Cysteine"),
                          ("UGC", "Cysteine"),
                          ("UGG", "Tryptophan") ]
