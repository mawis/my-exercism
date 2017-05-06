(ns queen-attack
  (:require [clojure.string :refer [join]]))

(defn generate-field [{:keys [b w]} line col]
  (cond
    (= b [line col]) "B"
    (= w [line col]) "W"
    :otherwise       "_"))

(defn generate-line [pos line]
  (->> (range 0 8)
       (map (partial generate-field pos line))
       (join " ")))

(defn board-string [pos]
  (->> (range 0 8)
       (map (partial generate-line pos))
       (map #(str % "\n"))
       (join)))

(defn can-attack [{:keys [w b]}]
  (or (= (first w) (first b))
      (= (second w) (second b))
      (= (Math/abs (- (first w) (first b)))
         (Math/abs (- (second w) (second b))))))
