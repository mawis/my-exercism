module Brackets (arePaired) where

arePaired :: String -> Bool
arePaired = arePaired' ""
  where arePaired' stack       ('(':xs) = arePaired' ('(':stack) xs
        arePaired' ('(':stack) (')':xs) = arePaired' stack       xs
        arePaired' _           (')':_)  = False
        arePaired' stack       ('[':xs) = arePaired' ('[':stack) xs
        arePaired' ('[':stack) (']':xs) = arePaired' stack       xs
        arePaired' _           (']':_)  = False
        arePaired' stack       ('{':xs) = arePaired' ('{':stack) xs
        arePaired' ('{':stack) ('}':xs) = arePaired' stack       xs
        arePaired' _           ('}':_)  = False
        arePaired' stack       (_:xs)   = arePaired' stack       xs
        arePaired' []          _        = True
        arePaired' _           _        = False
