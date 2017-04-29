module Base (rebase) where

import Data.List (unfoldr)

rebase :: Integral a => a -> a -> [a] -> Maybe [a]
rebase inBase outBase digits
  | any (< 2) [inBase, outBase] = Nothing
  | otherwise                   = digitize outBase <$> readNumber inBase digits
  where readNumber base = foldl shiftAdd (Just 0)
          where digit d
                  | d `elem` [0..base - 1] = Just d
                  | otherwise              = Nothing
                shiftAdd old new = (+) <$> ((* base) <$> old) <*> digit new
        digitize base = reverse . unfoldr nextDigit
          where nextDigit 0 = Nothing
                nextDigit n = Just (n `rem` base, n `div` base)
