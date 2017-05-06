module Queens (boardString, canAttack) where

boardString :: Maybe (Int, Int) -> Maybe (Int, Int) -> String
boardString white black = unlines $ map boardLine [0..7]
  where boardLine n =  unwords $ map boardField [0..7]
          where boardField m
                  | white == Just (n, m) = "W"
                  | black == Just (n, m) = "B"
                  | otherwise            = "_"

canAttack :: (Int, Int) -> (Int, Int) -> Bool
canAttack (x, y) (x', y') = abs (x - x') == abs (y - y') || x == x' || y == y'
