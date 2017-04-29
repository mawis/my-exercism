module Beer (song) where

import Data.Char (toUpper)
import Data.List (intercalate)

bottles :: Int -> String
bottles n
  | n == 0    = "no more bottles"
  | n == 1    = "1 bottle"
  | otherwise = show n ++ " bottles"

bottlesOfBeer :: Int -> String
bottlesOfBeer n = bottles n ++ " of beer"

capitalBottlesOfBeer :: Int -> String
capitalBottlesOfBeer n = let (x:xs) = bottlesOfBeer n
                         in toUpper x:xs

firstLine :: Int -> String
firstLine n = capitalBottlesOfBeer n ++ " on the wall, "
              ++ bottlesOfBeer n ++ ".\n"

takeOne :: Int -> String
takeOne n
  | n == 1    = "it"
  | otherwise = "one"

secondLine :: Int -> String
secondLine n = firstPart n ++ bottlesOfBeer ((n + 99) `mod` 100)
               ++ " on the wall.\n"
  where firstPart n'
          | n' == 0 = "Go to the store and buy some more, "
          | otherwise = "Take " ++ takeOne n' ++ " down and pass it around, "

verse :: Int -> String
verse n = firstLine n ++ secondLine n

song :: String
song = intercalate "\n" . map verse $ [99,98..0]
