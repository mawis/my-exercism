module Series (slices) where

slices :: Int -> String -> [[Int]]
slices 0 _   = [[]]
slices n str = map (map (read . (:[])))
               . takeWhile fullSlice
               . map (take n)
               $ iterate (drop 1) str
  where fullSlice s = n == length s
