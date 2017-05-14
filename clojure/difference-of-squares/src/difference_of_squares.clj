(ns difference-of-squares)

(defn square-of-sums [upper-limit]
  (let [sum (reduce + 0 (range 1 (inc upper-limit)))]
    (* sum sum)))

(defn sum-of-squares [upper-limit]
  (->> (range 1 (inc upper-limit))
       (map #(* % %))
       (reduce + 0)))

(defn difference [upper-limit]
  (- (square-of-sums upper-limit)
     (sum-of-squares upper-limit)))
