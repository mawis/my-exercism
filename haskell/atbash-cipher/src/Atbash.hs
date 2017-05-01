module Atbash (decode, encode) where

import Data.Char (chr, ord)
import Data.List (unwords)

decode :: String -> String
decode = (>>= replacement)
  where replacement c
          | 0x41 <= c' && c' <= 0x5a = [chr (0x7a - (c' - 0x41))]
          | 0x61 <= c' && c' <= 0x7a = [chr (0x7a - (c' - 0x61))]
          | 0x30 <= c' && c' <= 0x39 = [c]
          | otherwise = []
          where c' = ord c

encode :: String -> String
encode = unwords . group . decode
  where group = takeWhile (not . null) . map (take 5) . iterate (drop 5)
