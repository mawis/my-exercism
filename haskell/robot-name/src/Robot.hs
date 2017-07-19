module Robot (Robot, mkRobot, resetName, robotName) where

import Control.Concurrent (MVar, newMVar, readMVar, swapMVar)
import System.Random (newStdGen, randomRs)

newtype Robot = Robot (MVar String)

mkRobot :: IO Robot
mkRobot = do
  let name = genName >>= newMVar
  Robot `fmap` name

resetName :: Robot -> IO ()
resetName (Robot c) = do
  _ <- genName >>= swapMVar c
  return ()

robotName :: Robot -> IO String
robotName (Robot c) = readMVar c

genName :: IO String
genName = do
  g <- newStdGen
  let letters = randomRs ('A', 'Z') g
  let digits = randomRs('0', '9') g
  return $ take 2 letters ++ take 3 digits
