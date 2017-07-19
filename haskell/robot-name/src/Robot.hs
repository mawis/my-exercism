module Robot (Robot, mkRobot, resetName, robotName) where

import Control.Concurrent (MVar, newMVar, readMVar, swapMVar)
import Control.Monad (mapM)
import System.Random (randomRIO)

type Robot = MVar String

mkRobot :: IO Robot
mkRobot = genName >>= newMVar

resetName :: Robot -> IO ()
resetName r = genName >>= swapMVar r >> return ()

robotName :: Robot -> IO String
robotName = readMVar

genName :: IO String
genName = mapM randomRIO [letter, letter, digit, digit, digit]
  where letter = ('A', 'Z')
        digit = ('0', '9')
