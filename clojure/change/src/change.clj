(ns change)

(defn add-less-or-equal-coin [change-coins available-coins]
  (let [min-coin (last change-coins)]
    (map #(conj change-coins %) (filter #(<= % min-coin) available-coins))))

(defn one-more-coin [old-change-coins change coins]
  (let [new-change-coins
        (filter #(<= (reduce + %) change)
                (mapcat #(add-less-or-equal-coin % coins) old-change-coins))]
    (when (empty? new-change-coins)
      (throw (IllegalArgumentException. "cannot change")))
    new-change-coins))

(defn search-change [change-coins change coins]
  (loop [change-coins change-coins]
    (let [valid-change (some #(when (= (apply + %) change) %) change-coins)]
      (if valid-change valid-change
          (recur (one-more-coin change-coins change coins))))))

(defn issue [change coins]
  (cond
    (neg? change) (throw (IllegalArgumentException. "cannot change"))
    (zero? change) '()
    :otherwise (sort (search-change
                      (set (map #(conj [] %) coins))
                      change
                      coins))))
