(ns luhn)

(defn digit [d]
  (cond
    (<= \0 d \9) [(Character/getNumericValue d)]
    (= \space d) []
    :otherwise (throw (Exception. "Invalid digit"))))

(defn decode [number]
  (mapcat digit number))

(defn sum-reducer [[if-even if-odd] digit]
  [(mod (+ if-odd digit) 10)
   (mod (+ if-even (- (* digit 2) (if (>= digit 5) 9 0))) 10)])

(defn valid? [number]
  (try
    (let [digits (decode number)]
      (if (< (count (take 2 digits)) 2) false
          (->> digits
               (reduce sum-reducer [0 0])
               first
               zero?)))
    (catch Exception e false)))
