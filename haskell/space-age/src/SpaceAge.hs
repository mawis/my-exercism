module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune

ageOnEarthDividedBy :: Float -> Float -> Float
ageOnEarthDividedBy divisor = (/ divisor) . ageOn Earth

ageOn :: Planet -> Float -> Float
ageOn Earth = (/ 31557600)
ageOn Mercury = ageOnEarthDividedBy 0.2408467
ageOn Venus = ageOnEarthDividedBy 0.61519726
ageOn Mars = ageOnEarthDividedBy 1.8808158
ageOn Jupiter = ageOnEarthDividedBy 11.862615
ageOn Saturn = ageOnEarthDividedBy 29.447498
ageOn Uranus = ageOnEarthDividedBy 84.016846
ageOn Neptune = ageOnEarthDividedBy 164.79132
