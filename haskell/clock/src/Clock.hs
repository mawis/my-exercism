module Clock (clockHour, clockMin, fromHourMin, toString) where

import Text.Printf (printf)

data Clock = Clock Int deriving (Eq, Show)

instance Num Clock where
  fromInteger = fromHourMin 0 . fromIntegral
  (+) (Clock a) (Clock b) = Clock $ keepDay (a + b)
  (-) (Clock a) (Clock b) = Clock $ keepDay (a - b)
  (*) (Clock a) (Clock b) = Clock $ keepDay (a * b)
  abs = id
  signum (Clock a) = Clock $ keepDay(signum a)

clockHour :: Clock -> Int
clockHour (Clock minOfDay) = minOfDay `div` 60

clockMin :: Clock -> Int
clockMin (Clock minOfDay) = minOfDay `rem` 60

fromHourMin :: Int -> Int -> Clock
fromHourMin hour minu = Clock $ keepDay (hour * 60 + minu)

toString :: Clock -> String
toString c = printf "%02d:%02d" (clockHour c) (clockMin c)

keepDay :: Int -> Int
keepDay n = n `mod` (24 * 60)
