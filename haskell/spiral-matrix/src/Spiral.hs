module Spiral (spiral) where

spiral :: Int -> [[Int]]
spiral = subSpiral 1
  where subSpiral _ 0 = []
        subSpiral start 1 = [[start]]
        subSpiral start size' = [[upperLeft..upperRight]]
                                ++ map (\(a,b,c) -> a : b ++ [c])
                                (zip3 [innerStart - 1, innerStart - 2..]
                                 (subSpiral innerStart (size' - 2))
                                 [upperRight + 1..])
                                ++ [[lowerLeft, lowerLeft - 1 .. lowerRight]]
          where upperLeft = start
                upperRight = start + size' - 1
                lowerLeft = start + 3 * size' - 3
                lowerRight = start + 2 * size' - 2
                innerStart = start + 4 * size' - 4
