module Isogram (isIsogram) where

import qualified Data.Map as M
import Data.Char (toLower, isLetter)

isIsogram :: String -> Bool
isIsogram = M.null . onlyDups . charCount . map toLower . filter isLetter
  where charCount = foldr updateF M.empty
          where updateF = M.alter incKey
                  where incKey e = case e of
                          Just n -> Just (n + 1)
                          Nothing -> Just 1
        onlyDups :: M.Map Char Integer -> M.Map Char Integer
        onlyDups = M.filter (> 1)
