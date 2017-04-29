module Phone (number) where

import Data.Char (isDigit)

number :: String -> Maybe String
number n = cleanNumber n >>= testNumber

cleanNumber :: String -> Maybe String
cleanNumber = foldr clean (Just "")
  where clean digit acc
          | isDigit digit        = fmap (digit:) acc
          | digit `elem` "().- " = acc
          | otherwise            = Nothing

testNumber :: String -> Maybe String
testNumber n@[_, _, _, _, _, _, _, _, _, _] = Just n
testNumber n@['1', _, _, _, _, _, _, _, _, _, _] = Just $ tail n
testNumber _ = Nothing
