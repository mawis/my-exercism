module Robot
    ( Bearing(East,North,South,West)
    , bearing
    , coordinates
    , mkRobot
    , simulate
    , turnLeft
    , turnRight
    ) where

data Bearing = North
             | East
             | South
             | West
             deriving (Eq, Show)

data Robot = Robot Bearing (Integer, Integer)

bearing :: Robot -> Bearing
bearing (Robot b _) = b

coordinates :: Robot -> (Integer, Integer)
coordinates (Robot _ c) = c

mkRobot :: Bearing -> (Integer, Integer) -> Robot
mkRobot = Robot

simulate :: Robot -> String -> Robot
simulate = foldl simulateOne
  where simulateOne (Robot b c) 'R' = Robot (turnRight b) c
        simulateOne (Robot b c) 'L' = Robot (turnLeft b) c
        simulateOne r           'A' = advance r
        simulateOne _           _   = error "Invalid command"

turnLeft :: Bearing -> Bearing
turnLeft North = West
turnLeft East = North
turnLeft South = East
turnLeft West = South

turnRight :: Bearing -> Bearing
turnRight = turnLeft . turnLeft . turnLeft

advance :: Robot -> Robot
advance (Robot North (x,y)) = Robot North (x, y + 1)
advance (Robot East (x,y))  = Robot East (x + 1, y)
advance (Robot South (x,y)) = Robot South (x, y - 1)
advance (Robot West (x,y))  = Robot West (x - 1, y)
