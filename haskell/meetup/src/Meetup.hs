module Meetup (Weekday(..), Schedule(..), meetupDay) where

import Data.Time.Calendar (Day, fromGregorian, toGregorian)
import Data.Time.Calendar.WeekDate (toWeekDate)

data Weekday = Monday
             | Tuesday
             | Wednesday
             | Thursday
             | Friday
             | Saturday
             | Sunday
             deriving Enum

data Schedule = First
              | Second
              | Third
              | Fourth
              | Last
              | Teenth
              deriving Enum

meetupDay :: Schedule -> Weekday -> Integer -> Int -> Day
meetupDay Last weekday year month = last $ daysByWeekday weekday year month
meetupDay Teenth weekday year month = head
                                      . filter teenth
                                      $ daysByWeekday weekday year month
  where teenth day = dayOf (toGregorian day) `elem` [13..19]
        dayOf (_, _, d) = d
meetupDay schedule weekday year month = daysByWeekday weekday year month
                                        !! fromEnum schedule

daysByWeekday :: Weekday -> Integer -> Int -> [Day]
daysByWeekday weekday year month = filter byWeekday $ daysOfMonth year month
  where byWeekday day = weekdayOf (toWeekDate day) == 1 + fromEnum weekday
        weekdayOf (_, _, wd) = wd

daysOfMonth :: Integer -> Int -> [Day]
daysOfMonth year month = takeWhile sameMonth [fromGregorian year month 1..]
  where sameMonth date = monthOf (toGregorian date) == month
        monthOf (_, m, _) = m
