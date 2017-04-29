module ETL (transform) where

import Data.Char (toLower)
import Data.Map (Map)
import qualified Data.Map as M

transform :: Map a String -> Map Char a
transform legacyData = foldl addScore M.empty $ M.toList legacyData
  where addScore m (score, letters) =
          foldl (\acc ch -> M.insert (toLower ch) score acc) m letters
