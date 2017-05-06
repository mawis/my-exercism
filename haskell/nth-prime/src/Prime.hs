module Prime (nth) where

import Sieve (primesUpTo)

nth :: Int -> Maybe Integer
nth n
  | n < 1 = Nothing
  | otherwise = Just $
                (head . filter longEnough . map primesUpTo $
                 iterate (* 333) 333)
                !! (n - 1)
  where longEnough = (> n) . length
