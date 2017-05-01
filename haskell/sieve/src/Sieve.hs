module Sieve (primesUpTo) where

primesUpTo :: Integer -> [Integer]
primesUpTo n = reverse $ sieve [] [2..n]
  where sieve primes [] = primes
        sieve primes (x:xs) = sieve (x:primes)
                              (filter (not . (`elem` [x, 2 * x .. n])) xs)
