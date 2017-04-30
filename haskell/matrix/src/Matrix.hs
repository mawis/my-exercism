module Matrix
    ( Matrix
    , cols
    , column
    , flatten
    , fromList
    , fromString
    , reshape
    , row
    , rows
    , shape
    , transpose
    ) where

import Control.Monad (join)
import Data.List.Split (chunksOf, splitOn)
import Data.Vector (Vector)
import qualified Data.Vector as V

data Matrix a = Matrix (Vector (Vector a)) deriving (Eq, Show)

cols :: Matrix a -> Int
cols matrix
  | rows matrix == 0 = 0
  | otherwise        = V.length $ row 0 matrix

column :: Int -> Matrix a -> Vector a
column x (Matrix m) = V.map (V.! x) m

flatten :: Matrix a -> Vector a
flatten (Matrix m) = join m

fromList :: [[a]] -> Matrix a
fromList = Matrix . V.fromList . map V.fromList

fromString :: Read a => String -> Matrix a
fromString "" = Matrix V.empty
fromString xs = fromList . map (chain reads) $ splitOn "\n" xs

reshape :: (Int, Int) -> Matrix a -> Matrix a
reshape (_, cs)= fromList . chunksOf cs . V.toList . flatten

row :: Int -> Matrix a -> Vector a
row x (Matrix m) = (V.!) m x

rows :: Matrix a -> Int
rows (Matrix m) = V.length m

shape :: Matrix a -> (Int, Int)
shape matrix = (rows matrix, cols matrix)

transpose :: Matrix a -> Matrix a
transpose matrix
  | rows matrix == 0 = matrix
  | otherwise        = Matrix . V.fromList
                       . map (`column` matrix) $ [0..cols matrix -1]

chain :: (s -> [(a, s)]) -> s -> [a]
chain f s = case f s of
              [] -> []
              [(a, s')] -> a : chain f s'
              xs -> map fst xs ++ chain f (last $ map snd xs)
