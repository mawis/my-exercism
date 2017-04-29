(ns perfect-numbers)

(defn- aliquot [n]
  (reduce + (filter #(= (mod n %) 0) (range 1 n))))

(defn classify [n]
  (when-not (pos? n)
    (throw (IllegalArgumentException.)))
  (let [a (aliquot n)]
    (cond
      (= n a) :perfect
      (< n a) :abundant
      :else   :deficient)))
