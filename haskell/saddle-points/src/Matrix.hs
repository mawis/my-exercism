module Matrix (saddlePoints) where

import Data.Array (Array, bounds, indices, (!))

saddlePoints :: Ord e => Array (Int, Int) e -> [(Int, Int)]
saddlePoints matrix = filter testSaddlePoint (indices matrix)
  where testSaddlePoint candidate = all isHighest (row candidate)
                                    && all isLowest (column candidate)
          where isLowest = ((matrix ! candidate) <=)
                isHighest = ((matrix ! candidate) >=)
                column idx = map ((matrix !) . makeIndex) [0..rows]
                  where makeIndex r = (r, snd idx)
                        rows = fst . snd $ bounds matrix
                row idx = map ((matrix !) . makeIndex) [0..cols]
                  where makeIndex c = (fst idx, c)
                        cols = snd . snd $ bounds matrix
