module Anagram (anagramsFor) where

import Data.List (sort)
import Data.Char (toLower)

isAnagram :: String -> String -> Bool
isAnagram w a
  | w' == a'  = False
  | otherwise = sort w' == sort a'
  where w' = map toLower w
        a' = map toLower a

anagramsFor :: String -> [String] -> [String]
anagramsFor xs = filter (isAnagram xs)
