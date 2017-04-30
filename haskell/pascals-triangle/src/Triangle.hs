module Triangle (rows) where

rows :: Int -> [[Integer]]
rows x
  | x < 1 = []
  | otherwise = take x triangle
  where triangle = iterate nextRow [1]
        nextRow lastRow = [1] ++ zipWith (+) lastRow (drop 1 lastRow) ++ [1]
