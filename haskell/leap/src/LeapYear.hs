module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year = head $
                  [(400, True), (100, False), (4, True), (1, False)]
                  >>= check year
  where check y (interval, isLeap) = [isLeap | y `mod` interval == 0]
