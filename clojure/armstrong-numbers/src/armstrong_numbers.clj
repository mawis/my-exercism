(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as m]))

(defn digits [n]
  (->> n
       (iterate #(quot % 10))
       (take-while pos?)
       (map #(rem % 10))))

(defn armstrong? [num]
  (let [d (digits num)
        dcnt (count d)]
    (->> d
         (map #(m/expt % dcnt))
         (reduce +)
         (= num))))
