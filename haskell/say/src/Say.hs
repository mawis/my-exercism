module Say (inEnglish) where

import Control.Monad (join)

inEnglish :: Integer -> Maybe String
inEnglish n
  | n >= 1000000000000 = Nothing
  | n < 0              = Nothing
  | n == 0             = Just "zero"
  | otherwise          = Just . unwords $ numTokens n

numTokens :: Integer -> [String]
numTokens n
  | n >= 1000000000 = numTokens bils ++ "billion" : numTokens bilRest
  | n >= 1000000    = numTokens mils ++ "million" : numTokens milRest
  | n >= 1000       = numTokens thous ++ "thousand" : numTokens thouRest
  | n >= 100        = numTokens huns ++ "hundred" : numTokens hunRest
  | n == 90         = ["ninety"]
  | n == 80         = ["eighty"]
  | n == 70         = ["seventy"]
  | n == 60         = ["sixty"]
  | n == 50         = ["fifty"]
  | n == 40         = ["forty"]
  | n == 30         = ["thirty"]
  | n == 20         = ["twenty"]
  | n > 20          = [join (numTokens (n - unitPosition) ++ "-" : unitToken)]
  | n == 18         = ["eighteen"]
  | n == 15         = ["fifteen"]
  | n == 13         = ["thirteen"]
  | n == 12         = ["twelve"]
  | n == 11         = ["eleven"]
  | n == 10         = ["ten"]
  | n == 9          = ["nine"]
  | n == 8          = ["eight"]
  | n == 7          = ["seven"]
  | n == 6          = ["six"]
  | n == 5          = ["five"]
  | n == 4          = ["four"]
  | n == 3          = ["three"]
  | n == 2          = ["two"]
  | n == 1          = ["one"]
  | n == 0          = []
  | otherwise       = [join (unitToken ++ ["teen"])]
    where unitPosition = n `mod` 10
          (bils, bilRest) = n `divMod` 1000000000
          (mils, milRest) = n `divMod` 1000000
          (thous, thouRest) = n `divMod` 1000
          (huns, hunRest) = n `divMod` 100
          unitToken = numTokens unitPosition
