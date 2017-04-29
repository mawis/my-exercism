(ns hamming)

(defn distance [xs ys]
  (when (= (.length xs) (.length ys))
    (count (filter (fn [[x y]] (not= x y)) (map vector xs ys)))))
