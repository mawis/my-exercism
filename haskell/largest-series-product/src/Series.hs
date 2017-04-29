module Series (largestProduct) where

import Data.Char (digitToInt, isDigit)
import Data.List.Split (divvy)

largestProduct :: Int -> String -> Maybe Integer
largestProduct size _ | size < 0 = Nothing
largestProduct 0 "" = Just 1
largestProduct size num = maxEl . mapM (prod . digits) $ divvy size 1 num
  where digits = map digit
        digit n | isDigit n = Just . toInteger $ digitToInt n
        digit _ = Nothing
        prod s = product <$> sequence s
        maxEl Nothing = Nothing
        maxEl (Just []) = Nothing
        maxEl (Just [x]) = Just x
        maxEl (Just (x:xs)) = comp <$> sub
          where sub = maxEl (Just xs)
                comp maxs = if maxs > x then maxs else x
