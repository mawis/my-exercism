module Triangle (rows) where

rows :: Int -> [[Integer]]
rows x
  | x < 1 = []
  | otherwise = take x triangle

triangle :: [[Integer]]
triangle = iterate nextRow [1]

nextRow :: [Integer] -> [Integer]
nextRow lastRow = [1] ++ zipWith (+) lastRow (drop 1 lastRow) ++ [1]
