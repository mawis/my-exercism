module Roman (numerals) where

import Control.Monad (join)

encodings :: String
encodings = "IVXLCDM"

numerals :: Integer -> Maybe String
numerals = Just . join . reverse . zipWith encodeDigit codeGroups . digits
  where digits 0 = []
        digits n = n `rem` 10 : digits (n `div` 10)
        encodeDigit enc n | n `elem` [0..3] = replicate (fromIntegral n) $ head enc
        encodeDigit enc 4 = [head enc, enc !! 1]
        encodeDigit enc 9 = [head enc, enc !! 2]
        encodeDigit enc n = enc !! 1 : encodeDigit enc (n - 5)
        codeGroups = takeWhile (not . null) . map (take 3) . iterate (drop 2) $ encodings
