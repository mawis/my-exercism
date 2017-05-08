module OCR (convert) where

import Data.List (intercalate, transpose)
import Data.List.Split (chunksOf)

import qualified Data.Map as Map

digits :: Map.Map [String] Char
digits = Map.fromList [([" _ ",
                         "| |",
                         "|_|",
                         "   "], '0'),
                       (["   ",
                         "  |",
                         "  |",
                         "   "], '1'),
                       ([" _ ",
                         " _|",
                         "|_ ",
                         "   "], '2'),
                       ([" _ ",
                         " _|",
                         " _|",
                         "   "], '3'),
                       (["   ",
                         "|_|",
                         "  |",
                         "   "], '4'),
                       ([" _ ",
                         "|_ ",
                         " _|",
                         "   "], '5'),
                       ([" _ ",
                         "|_ ",
                         "|_|",
                         "   "], '6'),
                       ([" _ ",
                         "  |",
                         "  |",
                         "   "], '7'),
                       ([" _ ",
                         "|_|",
                         "|_|",
                         "   "], '8'),
                       ([" _ ",
                         "|_|",
                         " _|",
                         "   "], '9')]

convert :: String -> String
convert = intercalate "," . map decodeLine . chunksOf 4 . lines
  where decodeLine = (map decodeDigit . transpose) . map (chunksOf 3)
          where decodeDigit d = Map.findWithDefault '?' d digits
