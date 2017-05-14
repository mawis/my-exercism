(ns hexadecimal)

(defn digit [dig]
  (let [d (int dig)]
    (cond
      (<= (int \0) d (int \9)) (- d (int \0))
      (<= (int \a) d (int \f)) (+ (- d (int \a)) 10)
      :otherwise (throw (Exception.)))))

(defn hex-to-int [hex]
  (try
    (reduce #(+ (* %1 16) (digit %2)) 0 hex)
    (catch Exception e 0)))
