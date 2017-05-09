(ns hamming)

(defn distance [xs ys]
  (when (= (.length xs) (.length ys))
    (count (remove identity (map = xs ys)))))
