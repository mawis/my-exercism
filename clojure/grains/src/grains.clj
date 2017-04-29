(ns grains)

(defn square [field]
  (cond
    (<= field 0) (throw (IllegalArgumentException.))
    (< field 64) (bit-shift-left 1 (dec field))
    :else        (loop [f field
                        acc 1N]
                   (if (> f 63) (recur (dec f) (* acc 2N))
                       (* acc (square f))))))


(defn total []
  (reduce + (map square (range 1 65))))

;; alternative solution:
;; (defn total [] (dec (square 65)))
