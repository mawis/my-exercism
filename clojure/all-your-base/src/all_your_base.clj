(ns all-your-base)

(defn decode [base digits]
  (reduce #(+ (* %1 base) %2) 0 digits))

(defn encode [base value]
  (if (zero? value) '(0)
      (loop [value value
             digits '()]
        (if (zero? value) digits
            (recur (quot value base) (conj digits (rem value base)))))))

(defn convert [in-base digits out-base]
  (cond
    (some #(< % 0) digits) nil
    (some #(>= % in-base) digits) nil
    (< in-base 2) nil
    (< out-base 2) nil
    (empty? digits) digits
    :otherwise (encode out-base (decode in-base digits))))
