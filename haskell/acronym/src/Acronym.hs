module Acronym (abbreviate) where

import Data.Char (isAlpha, isUpper, toLower, toUpper)

abbreviate :: String -> String
abbreviate = filter isUpper
    . concatMap capitalize
    . words
    . map removePunctuation
  where removePunctuation c = if isAlpha c then c else ' '
        capitalize word@(x:xs)
          | all isUpper word = x : map toLower xs
          | otherwise        = toUpper x : xs
        capitalize xs        = xs
