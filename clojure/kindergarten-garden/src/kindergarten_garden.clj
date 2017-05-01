(ns kindergarten-garden
  (:require [clojure.string :refer [lower-case split-lines]]))

(def plant-by-char {\G :grass
                    \C :clover
                    \R :radishes
                    \V :violets})

(def default-students #{"Alice"
                        "Bob"
                        "Charlie"
                        "David"
                        "Eve"
                        "Fred"
                        "Ginny"
                        "Harriet"
                        "Ileana"
                        "Joseph"
                        "Kincaid"
                        "Larry"})

(defn student-keywords [students]
  (sort (map #(keyword (lower-case %)) students)))

(defn garden
  ([plants] (garden plants default-students))
  ([plants students]
   (->> plants
        split-lines
        (map (partial map (partial get plant-by-char)))
        (map (partial partition 2))
        (apply map vector)
        (map flatten)
        (zipmap (student-keywords students)))))
