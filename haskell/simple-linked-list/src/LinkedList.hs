module LinkedList
    ( LinkedList
    , datum
    , fromList
    , isNil
    , new
    , next
    , nil
    , reverseLinkedList
    , toList
    ) where

data LinkedList a = Element a (LinkedList a)
                  | Empty
                  deriving (Eq, Show)

datum :: LinkedList a -> a
datum (Element d _) = d
datum Empty = error "Empty list"

fromList :: [a] -> LinkedList a
fromList = foldr new nil

isNil :: LinkedList a -> Bool
isNil Empty = True
isNil _ = False

new :: a -> LinkedList a -> LinkedList a
new = Element

next :: LinkedList a -> LinkedList a
next (Element _ xs) = xs
next Empty = error "Empty list"

nil :: LinkedList a
nil = Empty

reverseLinkedList :: LinkedList a -> LinkedList a
reverseLinkedList = reverse' Empty
  where reverse' acc Empty = acc
        reverse' acc (Element x xs) = reverse' (Element x acc) xs

toList :: LinkedList a -> [a]
toList Empty = []
toList (Element x xs) = x:toList xs
