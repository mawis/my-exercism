module DNA (toRNA) where

toRNA :: String -> Maybe String
toRNA = traverse replaceNucleotide
  where replaceNucleotide 'G' = Just 'C'
        replaceNucleotide 'C' = Just 'G'
        replaceNucleotide 'T' = Just 'A'
        replaceNucleotide 'A' = Just 'U'
        replaceNucleotide _ = Nothing
