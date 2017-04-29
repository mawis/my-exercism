(ns binary-search)

(defn middle [v]
  (quot (count v) 2))

(defn search-for [n v]
  (loop [min  0
         max  (count v)]
    (if (= min max)
      (throw (Exception. "not found")))
    (let [mid  (+ min (quot (- max min) 2))
          elem (nth v mid)]
      (cond
        (= n elem) mid
        (< n elem) (recur min mid)
        :else      (recur (inc mid) max)))))
