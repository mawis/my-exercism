module House (rhyme) where

import Control.Monad (join)
import Data.List (drop, intercalate)

whoDidWhat :: [(String, String)]
whoDidWhat = [("horse and the hound and the horn", "belonged to"),
              ("farmer sowing his corn", "kept"),
              ("rooster that crowed in the morn", "woke"),
              ("priest all shaven and shorn", "married"),
              ("man all tattered and torn", "kissed"),
              ("maiden all forlorn", "milked"),
              ("cow with the crumpled horn", "tossed"),
              ("dog", "worried"),
              ("cat", "killed"),
              ("rat", "ate"),
              ("malt", "lay in"),
              ("house that Jack built.", "" )]

actions :: Int -> [(String, String)]
actions v = drop (11 - v) whoDidWhat

verseLines :: [(String, String)] -> [String]
verseLines [] = []
verseLines ((who, what):xs) = ("This is the " ++ who) : moreLines what xs
  where moreLines _ [] = []
        moreLines wht ((who', what'):xs') = thisLine : moreLines what' xs'
          where thisLine = "that " ++ wht ++ " the " ++ who'

verse :: Int -> String
verse = join . map (++ "\n") . verseLines . actions

rhyme :: String
rhyme = intercalate "\n" $ map verse [0..11]
