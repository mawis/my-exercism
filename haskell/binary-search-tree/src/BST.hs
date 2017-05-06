module BST
    ( BST
    , bstLeft
    , bstRight
    , bstValue
    , empty
    , fromList
    , insert
    , singleton
    , toList
    ) where

data BST a = Node a (BST a) (BST a) | Empty deriving (Eq, Show)

bstLeft :: BST a -> Maybe (BST a)
bstLeft (Node _ left@Node{} _) = Just left
bstLeft _ = Nothing

bstRight :: BST a -> Maybe (BST a)
bstRight (Node _ _ right@Node{}) = Just right
bstRight _ = Nothing

bstValue :: BST a -> Maybe a
bstValue (Node value _ _) = Just value
bstValue _ = Nothing

empty :: BST a
empty = Empty

fromList :: Ord a => [a] -> BST a
fromList = foldl (flip insert) empty

insert :: Ord a => a -> BST a -> BST a
insert x Empty = singleton x
insert x (Node val left right)
  | x <= val  = Node val (insert x left) right
  | otherwise = Node val left (insert x right)

singleton :: a -> BST a
singleton x = Node x Empty Empty

toList :: BST a -> [a]
toList Empty = []
toList (Node val left right) = toList left ++ val : toList right
