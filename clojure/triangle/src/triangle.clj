(ns triangle
  (:refer-clojure :exclude [type]))

(defn type [& lengths]
  (let [[a b c] (sort lengths)]
    (cond
      (= a b c) :equilateral
      (<= (+ a b) c) :illogical
      (distinct? a b c) :scalene
      :else :isosceles)))
