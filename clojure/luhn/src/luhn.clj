(ns luhn)

(defn digit [d]
  (let [unicode (int d)]
    (cond
      (<= 0x30 unicode 0x39) [(- unicode 0x30)]
      (= 0x20 unicode) []
      :otherwise (throw (Exception. "Invalid digit")))))

(defn decode [number]
  (mapcat digit number))

(defn sum-reducer [accu [is-odd digit]]
  (mod
   (+ accu
      (cond
        is-odd digit
        (>= digit 5) (- (* digit 2) 9)
        :otherwise (* digit 2)))
   10))

(defn valid? [number]
  (try
    (let [digits (decode number)
          length (count digits)]
      (if (< length 2) false
          (->> digits
               (map vector (iterate not (odd? length)))
               (reduce sum-reducer 0)
               zero?)))
    (catch Exception e false)))
