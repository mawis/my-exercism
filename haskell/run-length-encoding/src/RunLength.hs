module RunLength (decode, encode) where

import Data.Char
import Data.List

decode :: String -> String
decode encodedText
  | encodedText == "" = ""
  | isNumber (head encodedText) = foldr decodePair ""
                                  . asPairs $ groupBy grpNumber encodedText
  | otherwise                   = decode $ '1' : encodedText

asPairs :: [a] -> [(a, a)]
asPairs [] = []
asPairs (len : grp : xs) = (len, grp) : asPairs xs
asPairs _ = error "Even nummer of elements expected."

grpNumber :: Char -> Char -> Bool
grpNumber a b = isNumber a == isNumber b

decodePair :: (String, String) -> String -> String
decodePair (len, grp) accu = replicate (read len) (head grp) ++ tail grp ++ accu

encode :: String -> String
encode = foldr prependGroup "" . group

prependGroup :: String -> String -> String
prependGroup [c] accu = c : accu
prependGroup grp accu = show (length grp) ++ (head grp : accu)
