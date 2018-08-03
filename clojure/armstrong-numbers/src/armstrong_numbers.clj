(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as m]))

(defn digits
  ([num] (digits num ()))
  ([rem list] (if (zero? rem) list
                  (digits (quot rem 10) (conj list (mod rem 10))))))

(defn armstrong? [num]
  (let [d (digits num)
        dcnt (count d)]
    (->> d
         (map #(m/expt % dcnt))
         (reduce +)
         (= num))))
