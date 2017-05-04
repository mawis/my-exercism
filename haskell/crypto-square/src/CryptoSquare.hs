module CryptoSquare (encode) where

import Data.Char (isDigit, toLower)
import Data.List (transpose)

encode :: String -> String
encode xs = unwords
            . transpose
            $ partition sqSize cleaned
  where sqSize = ceiling doubleSqSize
          where doubleSqSize :: Double
                doubleSqSize = sqrt . fromIntegral $ length cleaned
        cleaned = cleanString xs
          where cleanString [] = []
                cleanString (c:cs)
                  | isDigit c                         = c:cleanString cs
                  | lowercaseLetter `elem` ['a'..'z'] = lowercaseLetter
                                                        :cleanString cs
                  | otherwise                         = cleanString cs
                  where lowercaseLetter = toLower c
        partition len = takeWhile (not . null)
                        . map (take len)
                        . iterate (drop len)
