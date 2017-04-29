module Triangle (TriangleType(..), triangleType) where

import Data.List (sort)

data TriangleType = Equilateral
                  | Isosceles
                  | Scalene
                  | Illegal
                  deriving (Eq, Show)

triangleType :: Real a => a -> a -> a -> TriangleType
triangleType a b c = triangleTest . reverse $ sort [a,b,c]

triangleTest :: Real a => [a] -> TriangleType
triangleTest sides@(x:xs)
  | any (< 0) sides = Illegal
  | x > sum xs = Illegal
  | all (== 0) sides = Illegal
  | all (== x) xs = Equilateral
  | all (== head xs) $ tail xs = Isosceles
  | x `elem` xs = Isosceles
  | otherwise = Scalene
triangleTest [] = Illegal
