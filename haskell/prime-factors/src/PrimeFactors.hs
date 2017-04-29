module PrimeFactors (primeFactors) where

primeFactors :: Integer -> [Integer]
primeFactors = primeFactors' 2
  where primeFactors' fac n
          | n < fac          = []
          | n `rem` fac == 0 = fac : primeFactors' fac (n `div` fac)
          | otherwise        = primeFactors' (fac + 1) n
