(ns sum-of-multiples)

(defn isMultiple? [factors num]
  (some #(zero? (mod num %)) factors))

(defn sum-of-multiples [factors limit]
  (reduce + (filter (partial isMultiple? factors) (range 1 limit))))
