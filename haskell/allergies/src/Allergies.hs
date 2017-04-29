module Allergies (Allergen(..), allergies, isAllergicTo) where

import Data.Bits (testBit)

data Allergen = Eggs
              | Peanuts
              | Shellfish
              | Strawberries
              | Tomatoes
              | Chocolate
              | Pollen
              | Cats
              deriving (Eq, Enum)

allergies :: Int -> [Allergen]
allergies score = filter (`isAllergicTo` score) $ enumFromTo Eggs Cats

isAllergicTo :: Allergen -> Int -> Bool
isAllergicTo allergen = (`testBit` fromEnum allergen)
