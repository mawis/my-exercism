module CollatzConjecture (collatz) where

collatz :: Integer -> Maybe Integer
collatz = helper 0
  where helper cnt n
          | n < 1  = Nothing
          | n == 1 = Just cnt
          | even n = helper nextCnt (n `div` 2)
          | otherwise = helper nextCnt (3 * n + 1)
          where nextCnt = cnt + 1
