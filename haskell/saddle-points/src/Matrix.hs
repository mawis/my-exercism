module Matrix (saddlePoints) where

import Data.Array (Array, bounds, indices, (!))

saddlePoints :: Ord e => Array (Int, Int) e -> [(Int, Int)]
saddlePoints matrix = filter testSaddlePoint (indices matrix)
  where testSaddlePoint candidate = all isHighest (row candidate)
                                    && all isLowest (column candidate)
          where isLowest = ((matrix ! candidate) <=)
                isHighest = ((matrix ! candidate) >=)
                column idx = map ((matrix !) . makeIndex) [minRow..maxRow]
                  where makeIndex r = (r, snd idx)
                        minRow = fst . fst $ bounds matrix
                        maxRow = fst . snd $ bounds matrix
                row idx = map ((matrix !) . makeIndex) [minCol..maxCol]
                  where makeIndex c = (fst idx, c)
                        minCol = snd . fst $ bounds matrix
                        maxCol = snd . snd $ bounds matrix
