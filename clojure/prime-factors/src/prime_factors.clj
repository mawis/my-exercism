(ns prime-factors)

(defn of [num]
  (assert (> num 0))
  (loop [num num
         factors []
         fac 2]
    (cond
      (= num 1)             factors
      (zero? (mod num fac)) (recur (quot num fac)
                                   (conj factors fac)
                                   fac)
      :else                 (recur num
                                   factors
                                   (inc fac)))))
