(ns octal)

(defn digit [dig]
  (let [d (- (int dig) (int \0))]
    (if (<= 0 d 7) d
        (throw (Exception.)))))

(defn to-decimal [oct]
  (try
    (reduce #(+ (* %1 8) (digit %2)) 0 oct)
    (catch Exception e 0)))
