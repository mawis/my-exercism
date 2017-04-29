(ns raindrops
  (:require [clojure.string :refer [join]]))

(defn test-for [num divisor word]
  (if (zero? (mod num divisor)) [word] []))

(defn convert [num]
  (let [check (partial test-for num)
        words (concat (check 3 "Pling")
                      (check 5 "Plang")
                      (check 7 "Plong"))]
    (if (empty? words) (str num) (join words))))
