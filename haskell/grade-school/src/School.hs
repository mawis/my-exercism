module School (School, add, empty, grade, sorted) where

import Data.List (groupBy)

type Student = (Int, String)
data School = School [Student]

add :: Int -> String -> School -> School
add gradeNum student (School school) = School (addStudent (gradeNum, student)
                                               school)

addStudent :: Student -> [Student] -> [Student]
addStudent stud [] = [stud]
addStudent stud (x:xs)
  | stud <= x = stud : x : xs
  | otherwise = x : (addStudent stud xs)

empty :: School
empty = School []

grade :: Int -> School -> [String]
grade gradeNum school = (filter (isGrade gradeNum) $ sorted school) >>= snd
  where isGrade gradeNum (num, _) = gradeNum == num

sorted :: School -> [(Int, [String])]
sorted (School school) = fmap gradeGroup $ groupBy isGradeGroup school
  where isGradeGroup (a, _) (b, _) = a == b
        gradeGroup students = (fst $ head students, fmap snd students)
