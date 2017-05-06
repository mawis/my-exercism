module Prime (nth) where

nth :: Int -> Maybe Integer
nth n
  | n < 1 = Nothing
  | otherwise = Just (primes [2..] !! (n - 1))
  where primes (x:xs) = x : primes (filter (\z -> z `mod` x /= 0) xs)
        primes [] = error "This should not happen"
