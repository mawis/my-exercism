module FoodChain (song) where

import Data.List (intercalate)

type Animal = String
type Reaction = Maybe String
type Extra = String
things :: [(Animal, Reaction, Extra)]
things = [("fly", Nothing, ""),
          ("spider",
           Just "It wriggled and jiggled and tickled inside her.",
           " that wriggled and jiggled and tickled inside her"),
          ("bird", Just "How absurd to swallow a bird!", ""),
          ("cat", Just "Imagine that, to swallow a cat!", ""),
          ("dog", Just "What a hog, to swallow a dog!", ""),
          ("goat", Just "Just opened her throat and swallowed a goat!", ""),
          ("cow", Just "I don't know how she swallowed a cow!", "")]

song :: String
song = unlines . intercalate [""] . map verse $ [0..7]
  where verse 7 = ["I know an old lady who swallowed a horse.",
                   "She's dead, of course!"]
        verse n = lineOne ++ reaction ++ intermediateLines ++ lastLine
          where lineOne = ["I know an old lady who swallowed a "
                           ++ animal ++ "."]
                  where animal = case thing of (an, _, _) -> an
                thing = things !! n
                reaction = case thing of
                             (_, Just re, _) -> [re]
                             _               -> []
                intermediateLines = map intermediateLine [n, n-1..1]
                  where intermediateLine n' = "She swallowed the "
                                              ++ animal' ++ " to catch the "
                                              ++ animal'' ++ extra'' ++ "."
                          where thing' = things !! n'
                                thing'' = things !! (n' - 1)
                                animal' = case thing' of (an, _, _) -> an
                                animal'' = case thing'' of (an, _, _) -> an
                                extra'' = case thing'' of (_, _, ex) -> ex
                lastLine = ["I don't know why she swallowed the fly. "
                            ++ "Perhaps she'll die."]
