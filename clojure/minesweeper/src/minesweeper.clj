(ns minesweeper
  (:require [clojure.string :refer [join split-lines]]))

(defn decode [mines]
  (->> (split-lines mines)
       (map (partial into []))
       (into [])))

(defn marked? [field col row]
  (= (get (get field row) col) \*))

(defn cell [field col row]
  (if (marked? field col row) \*
      (->> (for [c (range (- col 1) (+ col 2)) r (range (- row 1) (+ row 2))]
             (marked? field c r))
           (filter identity)
           (count)
           (+ 0x30)
           (char))))

(defn draw [mines]
  (let [field (decode mines)
        rows (count field)
        cols (count (first field))]
    (->> (for [r (range 0 rows)
               c (range 0 cols)]
           (let [cell-val (cell field c r)]
             (if (= cell-val \0) \space cell-val)))
         (partition cols)
         (map join)
         (join "\n"))))
