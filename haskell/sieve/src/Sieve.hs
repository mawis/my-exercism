module Sieve (primesUpTo) where

import Data.List ((\\))

primesUpTo :: Integer -> [Integer]
primesUpTo n = reverse $ sieve [] [2..n]
  where sieve primes [] = primes
        sieve primes (p:ps) = sieve (p:primes) (ps \\ [2 * p, 3 * p .. n])
