module Garden
    ( Plant (..)
    , defaultGarden
    , garden
    , lookupPlants
    ) where

import Control.Monad (join)
import Data.List (sort, transpose)
import Data.Map (Map, findWithDefault, fromList)

data Plant = Clover
           | Grass
           | Radishes
           | Violets
           deriving (Eq, Show)

plant :: Char -> Plant
plant 'C' = Clover
plant 'G' = Grass
plant 'R' = Radishes
plant 'V' = Violets
plant _ = error "No such plant"

defaultStudents :: [String]
defaultStudents = ["Alice", "Bob", "Charlie", "David",
                   "Eve", "Fred", "Ginny", "Harriet",
                   "Ileana", "Joseph", "Kincaid", "Larry"]

defaultGarden :: String -> Map String [Plant]
defaultGarden = garden defaultStudents

garden :: [String] -> String -> Map String [Plant]
garden students = fromList
                  . zip (sort students)
                  . map join
                  . transpose
                  . map split2Pairs
                  . plantRows
  where split2Pairs = takeWhile (not . null) . map (take 2) . iterate (drop 2)
        plantRows = map (map plant) . lines

lookupPlants :: String -> Map String [Plant] -> [Plant]
lookupPlants = findWithDefault []
