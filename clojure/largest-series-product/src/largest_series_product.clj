(ns largest-series-product)

(defn digit [dig]
  (let [d (- (int dig) (int \0))]
    (if (<= 0 d 9) d
        (throw (IllegalArgumentException. "Invalid digit")))))

(defn largest-product [len s]
  (cond
    (not-empty s) (->> (map digit s)
                       (partition len 1)
                       (map #(reduce * 1 %))
                       (apply max))
    (zero? len)   1
    :otherwise    (throw (IllegalArgumentException.))))
