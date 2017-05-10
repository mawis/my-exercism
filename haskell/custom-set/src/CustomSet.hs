module CustomSet
  ( delete
  , difference
  , empty
  , fromList
  , insert
  , intersection
  , isDisjointFrom
  , isSubsetOf
  , member
  , null
  , size
  , toList
  , union
  ) where

import Data.List (sort)
import Prelude hiding (null)

data CustomSet a = CustomSet [a] deriving (Eq, Show)

delete :: Eq a => a -> CustomSet a -> CustomSet a
delete x (CustomSet es) = CustomSet $ filter (/= x) es

difference :: Eq a => CustomSet a -> CustomSet a -> CustomSet a
difference setA (CustomSet setB) = foldr delete setA setB

empty :: CustomSet a
empty = CustomSet []

fromList :: (Ord a, Eq a) => [a] -> CustomSet a
fromList = foldr insert empty

insert :: (Ord a, Eq a) => a -> CustomSet a -> CustomSet a
insert x (CustomSet set)
  | x `elem` set = CustomSet set
  | otherwise    = CustomSet (sort (x:set))

intersection :: Eq a => CustomSet a -> CustomSet a -> CustomSet a
intersection (CustomSet setA) (CustomSet setB) = CustomSet
                                                 $ filter (`elem` setB) setA

isDisjointFrom :: Eq a => CustomSet a -> CustomSet a -> Bool
isDisjointFrom setA setB = null $ intersection setA setB

isSubsetOf :: Eq a => CustomSet a -> CustomSet a -> Bool
isSubsetOf setA setB = null $ difference setA setB

member :: Eq a => a -> CustomSet a -> Bool
member x (CustomSet set) = x `elem` set

null :: Eq a => CustomSet a -> Bool
null (CustomSet set) = set == []

size :: CustomSet a -> Int
size (CustomSet set) = length set

toList :: CustomSet a -> [a]
toList (CustomSet set) = set

union :: (Ord a, Eq a) => CustomSet a -> CustomSet a -> CustomSet a
union setA (CustomSet setB) = foldr insert setA setB
